package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class DiscussionQueryVO implements Serializable {
    /**
     * 每页记录数
     */
    @ApiModelProperty("每页记录数")
    private int pageSize = 10;
    /**
     * 当前页数
     */
    @ApiModelProperty("当前页数")
    private int currPage = 1;
    /**
     * 查询内容
     */
    @ApiModelProperty("查询内容")
    private String query;

    /**
     * 查询类型
     */
    @ApiModelProperty("查询类型")
    private int type = 1;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String order = "desc";

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "DiscussionQueryVO{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", query='" + query + '\'' +
                ", type=" + type +
                ", order='" + order + '\'' +
                '}';
    }
}
