package com.bwei.diyizhouzhoukaomoni02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.diyizhouzhoukaomoni02.bean.NetBean;
import com.bwei.diyizhouzhoukaomoni02.fragment.BazaarFragment;
import com.bwei.diyizhouzhoukaomoni02.fragment.HomeFragment;
import com.bwei.diyizhouzhoukaomoni02.fragment.IdeaFragment;
import com.bwei.diyizhouzhoukaomoni02.fragment.MessageFragment;
import com.bwei.diyizhouzhoukaomoni02.fragment.MoreFragment;
import com.bwei.diyizhouzhoukaomoni02.net.NetworkUtils;

import org.greenrobot.eventbus.EventBus;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.shouye)
    RadioButton mShouye;
    @BindView(R.id.xf)
    RadioButton mXf;
    @BindView(R.id.sc)
    RadioButton mSc;
    @BindView(R.id.tt)
    RadioButton mTt;
    @BindView(R.id.gd)
    RadioButton mGd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //默认显示首页
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flt,homeFragment).commit();

        //判断是否有网
        NetBean netBean=new NetBean();
        boolean connected = NetworkUtils.isConnected(MainActivity.this);
        if(!connected) {
            netBean.setNetzhuan("当前没网!!!");
        }
        else {
            netBean.setNetzhuan("网络连接中~");
        }
        //使用EventBus发送消息
        EventBus.getDefault().post(netBean);
    }
    @OnClick({R.id.flt, R.id.shouye, R.id.xf, R.id.sc, R.id.tt, R.id.gd})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.shouye:
                HomeFragment homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.flt,homeFragment).commit();
                break;
            case R.id.xf:
                IdeaFragment ideaFragment = new IdeaFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.flt,ideaFragment).commit();
                break;
            case R.id.sc:
                BazaarFragment bazaarFragment = new BazaarFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.flt,bazaarFragment).commit();
                break;
            case R.id.tt:
                MessageFragment messageFragment = new MessageFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.flt,messageFragment).commit();
                break;
            case R.id.gd:
                MoreFragment moreFragment = new MoreFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.flt,moreFragment).commit();
                break;
        }
    }
}
