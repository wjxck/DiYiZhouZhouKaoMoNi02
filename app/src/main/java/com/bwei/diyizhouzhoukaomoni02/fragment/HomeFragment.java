package com.bwei.diyizhouzhoukaomoni02.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwei.diyizhouzhoukaomoni02.GreenDaoHelper;
import com.bwei.diyizhouzhoukaomoni02.R;
import com.bwei.diyizhouzhoukaomoni02.adapter.MyAdapter;
import com.bwei.diyizhouzhoukaomoni02.adapter.RecAdapter;
import com.bwei.diyizhouzhoukaomoni02.bean.DaoSession;
import com.bwei.diyizhouzhoukaomoni02.bean.GankBean;
import com.bwei.diyizhouzhoukaomoni02.bean.NetBean;
import com.bwei.diyizhouzhoukaomoni02.bean.ResultsBean;
import com.bwei.diyizhouzhoukaomoni02.bean.UserBean;
import com.bwei.diyizhouzhoukaomoni02.net.NetworkUtils;
import com.bwei.diyizhouzhoukaomoni02.net.RetrofitHelper;
import com.bwei.diyizhouzhoukaomoni02.net.ServiceAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    ServiceAPI serviceAPI;
    RecAdapter adapter;
    @BindView(R.id.rec)
    RecyclerView mRec;
    private View view;
    private Unbinder unbinder;
    private DaoSession session;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载视图
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        session = GreenDaoHelper.getDaoSession(getActivity());
        unbinder = ButterKnife.bind(this, view);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        //创建ServerApi对象
        serviceAPI = RetrofitHelper.getServiceAPI();

        boolean connected = NetworkUtils.isConnected(getActivity());
        if (!connected) {
            //无网络状态下
            //查询数据库
            List<UserBean> userBeans = session.getUserBeanDao().loadAll();
            MyAdapter myAdapter = new MyAdapter(userBeans, getActivity());
            mRec.setAdapter(myAdapter);
        } else {
            Toast.makeText(getActivity(), "有网", Toast.LENGTH_SHORT).show();
            Call<GankBean<ResultsBean>> bean = serviceAPI.bean(10, 1);
            bean.enqueue(new Callback<GankBean<ResultsBean>>() {
                @Override
                public void onResponse(Call<GankBean<ResultsBean>> call, Response<GankBean<ResultsBean>> response) {
                    //请求成功
                    final GankBean<ResultsBean> body = response.body();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //实例化适配器
                            adapter = new RecAdapter(body.getResults(), getActivity());
                            mRec.setAdapter(adapter);

                            //存值到数据库
                            for (int i = 0; i < body.getResults().size(); i++) {
                                ResultsBean resultsBean = body.getResults().get(i);
                                UserBean userBean = new UserBean(System.currentTimeMillis(), resultsBean.getPublishedAt(), resultsBean.getDesc(), resultsBean.getType());
                                session.insert(userBean);
                            }
                        }
                    });
                }

                @Override
                public void onFailure(Call<GankBean<ResultsBean>> call, Throwable t) {

                }
            });
        }
        return view;
    }

    @Subscribe
    public void isNetWork(NetBean netBean) {
        Toast.makeText(getContext(), netBean.getNetzhuan(), Toast.LENGTH_LONG).show();
        //判断
        if (netBean.getNetzhuan().equals("网络连接中~")) {
            Call<GankBean<ResultsBean>> beanCall = serviceAPI.bean(10, 1);
            beanCall.enqueue(new Callback<GankBean<ResultsBean>>() {
                @Override
                public void onResponse(Call<GankBean<ResultsBean>> call, Response<GankBean<ResultsBean>> response) {
                    //请求成功
                    GankBean<ResultsBean> gankBean = response.body();
                }

                @Override
                public void onFailure(Call<GankBean<ResultsBean>> call, Throwable t) {

                }
            });
        }
    }

    //销毁防止内存泄露
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
