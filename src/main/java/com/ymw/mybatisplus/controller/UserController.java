package com.ymw.mybatisplus.controller;

import com.ymw.mybatisplus.bean.User;
import com.ymw.mybatisplus.common.AbstractRestService;
import com.ymw.mybatisplus.common.ResponseResult;
import com.ymw.mybatisplus.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ymingwang
 */
@RestController
@Api(value = "用户测试模块")
public class UserController extends AbstractRestService {

    @Autowired
    private UserService userService;

    /**
     * 查询全部
     *
     * @return
     * @Author ymingwang
     * @Date 2019/6/12 0012 19:29
     * @Param [page, size]
     */
    @GetMapping("/listAll")
    public List<User> listAll(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size) {
        List<User> list = userService.listAll(page, size);
        return list;
//        return this.buildSuccessResult(list);
    }

    /**
     * 添加数据
     *
     * @return
     * @Author ymingwang
     * @Date 2019/6/12 0012 19:30
     * @Param [user]
     */
    @ApiOperation(value = "添加用户", notes = "根据参数添加用户")
    @PostMapping("/insert")
    public ResponseResult insert(@RequestBody User user) {
        try { // userService.save(user)
            return this.buildSuccessResult(userService.insert(user), "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildErrorResult(500, "添加用户出错");
        }
    }

    /**
     * 删除
     *
     * @return
     * @Author ymingwang
     * @Date 2019/6/12 0012 19:31
     * @Param [userId]
     */
    @DeleteMapping("/remove")
    @PostMapping("/remove")
    public ResponseResult<Integer> remove(@RequestBody Integer userId) {
        System.out.println("remove  " + userId);
        User user = userService.getById(userId);
        try {
            int result = userService.remove(userId);
            if (result > 0) {
                return this.buildSuccessResult(result, "删除用户成功");
            }
            return this.buildErrorResult(result, "删除用户失败");
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildErrorResult(500, "删除用户出错");
        }
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody User user) {
        try {
            return this.buildSuccessResult(userService.update(user), "更改用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildErrorResult("更改用户信息出错");
        }
    }

}
