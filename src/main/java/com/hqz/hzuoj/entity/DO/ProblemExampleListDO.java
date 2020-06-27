package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (ProblemExample)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Data
public class ProblemExampleListDO implements Serializable {
    private static final long serialVersionUID = -92397934252878613L;

    /**
    * 输入样例
    */
    @ApiModelProperty("输入样例")
    private String inputContent;
    /**
    * 输出样例
    */
    @ApiModelProperty("输出样例")
    private String outputContent;


    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getOutputContent() {
        return outputContent;
    }

    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }


    @Override
    public String toString() {
        return "ProblemExampleDO{" +
                ", inputContent='" + inputContent + '\'' +
                ", outputContent='" + outputContent + '\'' +
                '}';
    }
}
