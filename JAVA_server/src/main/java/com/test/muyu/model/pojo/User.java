package com.test.muyu.model.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String userName;
    private Integer count;
    private String createTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.createTime = sdf.format(createTime);
    }
}
