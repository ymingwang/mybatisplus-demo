package com.ymw.easycode.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author ymw
 * @since 2019-12-09 19:07:23
 */
@Data
@TableName("user")
public class User implements Serializable{

    private static final long serialVersionUID = -74760612002497974L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;
    private String password;
    //创建时间private Object gmtCreate;
    private Object gmtModified;

}
