package com.ymw.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymw.mybatisplus.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectListPage(Page<User> page);

    Integer countUser();

    String getPassword(String username);

    int addMoreFile();
}
