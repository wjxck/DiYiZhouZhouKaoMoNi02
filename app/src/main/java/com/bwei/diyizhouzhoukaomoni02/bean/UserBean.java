package com.bwei.diyizhouzhoukaomoni02.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class UserBean {

    @Id(autoincrement = true)
    Long id;
    private String publishedAt;
    private String des;
    private String type;

    @Generated(hash = 1903720241)
    public UserBean(Long id, String publishedAt, String des, String type) {
        this.id = id;
        this.publishedAt = publishedAt;
        this.des = des;
        this.type = type;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
