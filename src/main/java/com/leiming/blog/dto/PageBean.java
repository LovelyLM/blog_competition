package com.leiming.blog.dto;

import java.util.List;

public class PageBean {
    private Integer pageSize;

    private Integer currentPage;

    private Integer totalCount;


    private Integer totalPage;


    private List list;



    public PageBean(Integer currentPage,Integer totalCount,Integer pageSize)
    {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        if(this.currentPage == null)
        {
            this.currentPage = 1;
        }
        if(this.pageSize == null)
        {
            this.pageSize = 5;
        }


        this.totalPage = (int) Math.ceil(1.0 * this.totalCount / this.pageSize);



        if(this.currentPage > this.totalPage)
        {
            this.currentPage = this.totalPage;
        }
        if(this.currentPage < 1)
        {
            this.currentPage = 1;
        }

    }


    //select * from message limit ?,?
    public Integer getStart()
    {
        return (this.currentPage-1)*this.pageSize;
    }


    public Integer getPageSize() {
        return pageSize;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public Integer getCurrentPage() {
        return currentPage;
    }


    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }


    public Integer getTotalCount() {
        return totalCount;
    }


    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }


    public Integer getTotalPage() {
        return totalPage;
    }


    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


    public List getList() {
        return list;
    }


    public void setList(List list) {
        this.list = list;
    }
}
