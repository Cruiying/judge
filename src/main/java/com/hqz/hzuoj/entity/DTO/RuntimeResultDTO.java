package com.hqz.hzuoj.entity.DTO;


import lombok.Data;

import java.io.Serializable;

@Data
public class RuntimeResultDTO implements Serializable {

    private Integer score;

    private String runtimeResult;
}
