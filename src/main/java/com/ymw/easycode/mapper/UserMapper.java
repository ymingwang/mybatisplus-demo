package com.ymw.easycode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ymw.easycode.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表mapper接口
 *
 * @author ymw
 * @since 2019-12-09 19:07:26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
