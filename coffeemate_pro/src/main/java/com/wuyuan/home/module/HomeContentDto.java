package com.wuyuan.home.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuwuyuan on 2017/7/30.
 */
public class HomeContentDto implements Serializable {
    private static final long serialVersionUID = 4534889949807650467L;

    private String title;
    private String groupId;
    private List<ArticleListDto> articleList;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<ArticleListDto> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListDto> articleList) {
        this.articleList = articleList;
    }
}
