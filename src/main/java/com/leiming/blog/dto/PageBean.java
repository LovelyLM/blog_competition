package com.leiming.blog.dto;

import java.util.List;

public class PageBean {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalCount;
    private Integer totalPage;
    private List list;
    public PageBean(Integer currentPage,Integer totalCount,Integer pageSize){
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

    }
}
