package com.wuyuan.home.module;

import com.happylifeplat.plugin.mybatis.pager.PageParameter;

/**
 * Created by xuwuyuan on 2017/7/23.
 */
public class GeneralRequestDto {
    private PageParameter page;
    private String orderBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public PageParameter getPage() {
        return page;
    }

    public void setPage(PageParameter page) {
        this.page = page;
    }
}
