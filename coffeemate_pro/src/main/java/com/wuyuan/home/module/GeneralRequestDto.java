package com.wuyuan.home.module;

import com.happylifeplat.plugin.mybatis.pager.PageParameter;

/**
 * Created by xuwuyuan on 2017/7/23.
 */
public class GeneralRequestDto {
    private PageParameter page;
    private String orderBy;
    private String groupId;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

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
