package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProblemQueryVO implements Serializable {
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
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
     * 标签列表
     */
    @ApiModelProperty("标签列表")
    private String tags;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    private String levelCode;

    @Override
    public String toString() {
        return "ProblemQueryVO{" +
                "title='" + title + '\'' +
                ", pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", tags='" + tags + '\'' +
                ", levelCode='" + levelCode + '\'' +
                '}';
    }
}
