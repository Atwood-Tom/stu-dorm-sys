package Model;

import javax.servlet.http.HttpServletRequest;

public class Page {
    private String searchText;//搜索的内容
    private String sortOrder;//排序的方式
    private Integer pageSize;//每页的数量
    private Integer pageNumber;//当前页码


    public static Page parse(HttpServletRequest req){
        Page page=new Page();
        page.searchText=req.getParameter("searchText");
        page.sortOrder=req.getParameter("sortOrder");
        page.pageSize=Integer.parseInt(req.getParameter("pageSize"));
        page.pageNumber=Integer.parseInt(req.getParameter("pageNumber"));
        return page;
    }

    @Override
    public String toString() {
        return "Page{" +
                "searchText='" + searchText + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                '}';
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
