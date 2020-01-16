package com.ymw.mybatisplus.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: ymingwang
 * @create: 2019-06-13 11:15
 **/
@ApiModel(description = "返回响应数据")
@Data
public class RestMessage {

    @ApiModelProperty(value = "错误信息")
    private String message;
    @ApiModelProperty(value = "状态码")
    private String code;
    @ApiModelProperty(value = "返回数据")
    private Object data;

}
