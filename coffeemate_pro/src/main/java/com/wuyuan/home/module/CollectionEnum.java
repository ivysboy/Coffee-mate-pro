package com.wuyuan.home.module;

/**
 * Created by xuwuyuan on 2017/8/9.
 */
public enum CollectionEnum {

    COLLECT(1),
    DIS_COLLECT(2);

    private Integer index;

    CollectionEnum(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    static public CollectionEnum getCollection(Integer index) {
        if(index == null) {
            return null;
        }

        for(CollectionEnum collection: CollectionEnum.values()) {
            if(index == collection.getIndex()) {
                return collection;
            }
        }
        return null;
    }
}
