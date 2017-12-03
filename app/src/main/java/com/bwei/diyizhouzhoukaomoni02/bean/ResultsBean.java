package com.bwei.diyizhouzhoukaomoni02.bean;

import com.bwei.diyizhouzhoukaomoni02.net.ImageTypeConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;


@Entity
public class ResultsBean {
    /**
     * _id : 5a1937af421aa90fe50c023b
     * createdAt : 2017-11-25T17:28:15.605Z
     * desc : florent37 开源了一个很有意思的项目，MyLittleCanvas，用来替代“难用”的 canvas
     * publishedAt : 2017-11-30T13:11:10.665Z
     * source : web
     * type : Android
     * url : https://github.com/florent37/MyLittleCanvas
     * used : true
     * who : drakeet
     * images : ["http://img.gank.io/fef497ed-83ba-46f6-8a94-0e7b724e1c10"]
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    @Convert(converter = ImageTypeConverter.class, columnType = String.class)
    private List<String> images;

    @Generated(hash = 256478809)
    public ResultsBean(String _id, String createdAt, String desc,
            String publishedAt, String source, String type, String url,
            boolean used, String who, List<String> images) {
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.publishedAt = publishedAt;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
        this.images = images;
    }

    @Generated(hash = 1822271928)
    public ResultsBean() {
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getUsed() {
        return this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return this.who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ResultsBean{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                ", images=" + images +
                '}';
    }
}
