package com.ymw.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymw.mybatisplus.bean.User;
import com.ymw.mybatisplus.mapper.UserMapper;
import com.ymw.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

/**
 * @author ymingwang
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listAll(int page, int size) {
        Page pageObj = new Page(page, size);
//        return userMapper.selectPage(pageObj,null);
        return userMapper.selectListPage(pageObj);
    }

    @Override
    public boolean hasThisUser(User user) {
        List<Object> userList = userMapper.selectObjs(new QueryWrapper<User>()
                .eq("username", user.getUsername()).eq("password", user.getPassword()));
        if (userList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insert(User user) {
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        System.out.println("插入的user = " + user);
//        return userMapper.insert(user);
        return userMapper.addMoreFile();
    }

    @Override
    public int remove(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }
}
