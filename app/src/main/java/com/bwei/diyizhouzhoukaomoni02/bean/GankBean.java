package com.bwei.diyizhouzhoukaomoni02.bean;

import java.util.List;

public class GankBean<T> {

    /**
     * error : false
     * results : [{"_id":"5a1937af421aa90fe50c023b","createdAt":"2017-11-25T17:28:15.605Z","desc":"florent37 开源了一个很有意思的项目，MyLittleCanvas，用来替代\u201c难用\u201d的 canvas","publishedAt":"2017-11-30T13:11:10.665Z","source":"web","type":"Android","url":"https://github.com/florent37/MyLittleCanvas","used":true,"who":"drakeet"},{"_id":"5a1f5fd2421aa90fe2f02c98","createdAt":"2017-11-30T09:33:06.290Z","desc":"GitHub年度报告，2017年编程语言之争，谁与争锋？","publishedAt":"2017-11-30T13:11:10.665Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU3NzA0ODQzMw==&mid=2247483675&idx=1&sn=b6f0a4e71d5164cf2201bcd8b6df8969","used":true,"who":"陈宇明"},{"_id":"5a137c67421aa90fef20354d","createdAt":"2017-11-21T09:07:51.275Z","desc":"iOS 和 Android 开发是否要采用 React Native?","publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483866&idx=1&sn=b5cad7e5c26d001d920b0eff0625a995&key=6571080d88416c7220506cd2febefb7313338d6e5ef958258d4c8740d2dfc118bcca1c3edef0a834a293256d27046ecda4902f4b359f8550d6db0b150d4de080cfb515dbef6bd2654b3e3f35e3a625e7&ascene=0&uin=NTI1MzE1NDE1&devicetype=iMac+MacBookPro12%2C1+OSX+OSX+10.12.6+build(16G29)&version=12020610&nettype=WIFI&fontScale=100&pass_ticket=B5BwzwdLM8k1Q49ldLzImBZOjI9TR1ZOuqEJVskf%2B3xP0nK44%2FBkaEEXGpYDvsxG","used":true,"who":null},{"_id":"5a1627fe421aa90fe2f02c80","createdAt":"2017-11-23T09:44:30.245Z","desc":"适配三星Galaxy S8及S8+","publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488324&idx=1&sn=e043220e37d6eaaff217769f4061c04e","used":true,"who":"陈宇明"},{"_id":"5a16379e421aa90fef203556","createdAt":"2017-11-23T10:51:10.599Z","desc":"我为Dexposed续一秒\u2014\u2014论ART上运行时 Method AOP实现","images":["http://img.gank.io/fef497ed-83ba-46f6-8a94-0e7b724e1c10"],"publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"Android","url":"http://weishu.me/2017/11/23/dexposed-on-art/","used":true,"who":"weishu"},{"_id":"5a1690c9421aa90fe50c0231","createdAt":"2017-11-23T17:11:37.734Z","desc":"Glide 源码学习,了解 Glide 图片加载原理","publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/9d8aeaa5a329","used":true,"who":"Kai Sun"},{"_id":"5a16a841421aa90fe50c0233","createdAt":"2017-11-23T18:51:45.222Z","desc":"Android上简洁轻量级的饼图控件","publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"Android","url":"https://github.com/razerdp/AnimatedPieView/tree/master","used":true,"who":"WeiChaoFeng"},{"_id":"5a177d91421aa90fe7253662","createdAt":"2017-11-24T10:01:53.156Z","desc":"Facebook面经记","publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488337&idx=2&sn=cdf09c45bafd09b07687cefa6149cc5d","used":true,"who":"陈宇明"},{"_id":"5a123f78421aa90fe50c0221","createdAt":"2017-11-20T10:35:36.599Z","desc":"Android 借助 Python 实现自动打包上传 fir","publishedAt":"2017-11-20T12:42:06.454Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s/BUht6BR0T0yAi6RrAVIwQA","used":true,"who":null},{"_id":"5a125bc4421aa90fe725364f","createdAt":"2017-11-20T12:36:20.851Z","desc":"Twitter 开源了一套全新的对象序列化方案。","publishedAt":"2017-11-20T12:42:06.454Z","source":"chrome","type":"Android","url":"https://github.com/twitter/Serial","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<T> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GankBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
