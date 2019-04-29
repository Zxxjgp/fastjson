package com.example.fastjson.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Person
 * @date 2019/4/23  11:49
 */
public class Person {
    private int id;

    private String name;

    @JSONField(format = "yyyy-MM-dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
