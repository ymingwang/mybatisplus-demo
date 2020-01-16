package com.ymw.mybatisplus.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ymw.mybatisplus.bean.User;

import java.util.List;

/**
 * @author ymingwang
 */
public interface UserService extends IService<User> {

    List<User> listAll(int page, int size);

    boolean hasThisUser(User user);

    int insert(User user);

    int remove(Integer userId);

    int update(User user);

}
