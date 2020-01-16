package com.ymw.mybatisplus.bean;/**
 * Created by ymingwang on 2019/6/13 0013.
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @author: ymingwang
 * @create: 2019-06-13 18:56
 **/
@Data
@Entity
@Table(name = "t_code")
public class Code {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "验证码主键ID")
    private Integer id;

    private String rightCode;

    private String addressIp;

    private Date date;

}
