package com.kshrd.registration.utillity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Pagination {
    private int page;
    private int limit; // how many data show in one page
    private int nextPage;
    private int previousPage;
    private int totalCount;
    private int totalPages;
    private int pageToShow; //pageToShow = 5; startPage 1 & endPage 5, 3 -> 7,...
    private int startPage; //show start from page with PageToShow;
    private int endPage; //show the end page with pageToShow;

    @JsonIgnore
    private int offset; // starting points

//    public Pagination() {
//        this(1, 10,  0, 5);
//    }

    public Pagination(int page, int limit, int totalCount) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.pageToShow = 5;
        setTotalCount(totalCount);
    }

    public Pagination(int page, int limit, int totalCount, int pagesToShow) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.pageToShow = pagesToShow;
        setTotalCount(totalCount);
    }

    // getter & setter
    public int getPage() {
        return page;
    }

    public void setPage(int currentPage) {
        this.page = (currentPage <= 1 ? 1 : currentPage);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPages(){
        return (int) Math.ceil((double) this.totalCount/limit);
    }
    public void setTotalPages(int totalPages){this.totalPages=totalPages;}

    public int getOffset(){return (this.page-1)*this.limit; }

    public int getNextPage(){return (int)(page>= getTotalPages()? getTotalPages():page+1);}

    public int getPreviousPage(){return (int) (page<=1? 1 : page-1);}

    public int getPageToShow(){
         return pageToShow;
//        return pageToShow > totalPages ? totalPages : pageToShow; //@Seng added;
    };

    //@seng added
    public void setPageToShow(int pageToShow) {
        this.pageToShow = pageToShow;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getTotalCount(){ return totalCount; }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        this.setStartPageEndPage(getTotalPages());
    }

    private void setStartPageEndPage(int totalPages){
        int halfPagesToShow = pageToShow/2;

        if (totalPages <= pageToShow){
//            startPage = 1;
            setStartPage(1);
//            endPage = totalPages;
            setEndPage(totalPages);
        }else if(page - halfPagesToShow <= 0){
//            startPage = 1 ;
            setStartPage(1);
//            endPage = pageToShow;
            setEndPage(pageToShow);
        }else if (page + halfPagesToShow == totalPages){
//            startPage=page - halfPagesToShow + 1;// I added my own
            setStartPage(page - halfPagesToShow + 1);
//            endPage = totalPages;
            setEndPage(totalPages);
        }else  if (page + halfPagesToShow > totalPages){
//            startPage = totalPages - pageToShow + 1;
            setStartPage(totalPages - pageToShow + 1);
//            endPage = totalPages;
            setEndPage(totalPages);
        }else {
//            startPage = page - halfPagesToShow;
            setStartPage(page - halfPagesToShow);
//            endPage = page + halfPagesToShow;
            setEndPage(page + halfPagesToShow);
        }
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", nextPage=" + nextPage +
                ", previousPage=" + previousPage +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", pageToShow=" + pageToShow +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", offset=" + offset +
                '}';
    }
}
