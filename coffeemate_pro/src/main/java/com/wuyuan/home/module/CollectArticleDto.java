package com.wuyuan.home.module;

import java.io.Serializable;

/**
 * Created by xuwuyuan on 2017/8/9.
 */
public class CollectArticleDto implements Serializable {

    private static final long serialVersionUID = -7304317951739219031L;

    private String id;
    private String articleId;
    private String userId;
    private int operation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

}
