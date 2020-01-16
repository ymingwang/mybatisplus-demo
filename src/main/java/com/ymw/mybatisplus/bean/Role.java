package com.ymw.mybatisplus.bean;

import lombok.Data;

import java.security.Permissions;
import java.util.Set;

/**
 * 角色类
 *
 * @author ymingwang
 * @Date 2019/11/06
 */
@Data
public class Role {

    private String id;

    private String roleName;

    private Set<Permissions> permissions;

}
