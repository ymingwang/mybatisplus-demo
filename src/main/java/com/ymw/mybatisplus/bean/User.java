package com.ymw.mybatisplus.bean;

import java.io.Serializable;
import java.util.Date;

//@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3113755826572877652L;
    /**
    主键ID 数据库ID自增
     */
//    @TableId(type = IdType.AUTO) // 实体id自增 该注释 会让传入实体的id无效 依然按照自增的id添加
//    @TableId(type=IdType.INPUT) // id输入
    private Integer id;

    /**
    用户名
     */
    private String username;

    /**
    密码
     */
    private String password;

    /**
    创建时间
     */
    private Date gmtCreate;

    /**
    修改时间
     */
    private Date gmtModified;

    public User() {
    }

    public User(Integer id, String username, String password, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public Date getGmtModified() {
        return this.gmtModified;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(final Object o) {
        return o.toString().equals(this.toString());
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() +
                ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
