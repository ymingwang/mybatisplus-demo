package com.ymw.easycode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymw.easycode.mapper.UserMapper;
import com.ymw.easycode.entity.User;
import com.ymw.easycode.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author ymw
 * @since 2019-12-09 19:07:24
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
