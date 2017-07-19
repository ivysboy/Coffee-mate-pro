package com.wuyuan.base.module;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/19.
 */
public class CommonVO {
    @JsonProperty("title")
    private String name;

    @JsonProperty("list")
    private List<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
