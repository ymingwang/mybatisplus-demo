package com.ymw.mybatisplus.controller;/**
 * Created by ymingwang on 2019/10/23 0023.
 */

import com.ymw.mybatisplus.bean.User;
import com.ymw.mybatisplus.common.AjaxResult;
import com.ymw.mybatisplus.common.BaseController;
import com.ymw.mybatisplus.service.UserService;
import com.ymw.mybatisplus.utils.ShiroUtils;
import com.ymw.mybatisplus.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * @description:
 * @author: ymingwang
 * @create: 2019-10-23 20:16
 **/
@Controller
public class LoginController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @PostMapping("/submitLogin")
    public String login(String username, String password, RedirectAttributes redirectAttributes, ModelMap mmp) {
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        if (userService.hasThisUser(loginUser)) {
            mmp.put("user", loginUser);
            log.info("用户 " + loginUser.getUsername() + " 登录成功" + " <--> " + new Date());
            return "main";
        } else {
//            mmp.put("msg", "用户名或密码错误"); // 要是登录失败 采用重定向 信息会在 model里面丢失
                                                  // 所以spring3.1版本后提供RedirectAttributes解决信息丢失问题
            redirectAttributes.addFlashAttribute("msg", "用户名或密码错误");
            log.error("username = " + loginUser.getUsername() + " , password = " + loginUser.getPassword() + " 登录失败 "  + " <--> " + new Date());
        }
        // 重定向
        return "redirect:/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(String username, String password, ModelMap mmp) {
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            mmp.put("user", loginUser);
            return success();
//            return "main";
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            log.error(msg);
            return error(msg);
            // 重定向
//            return "redirect:/login";
        }
    }

    @ResponseBody
    @GetMapping("/getMsg")
    public String getStr() {
        return "wwww";
    }
    @GetMapping("/main")
//    @RequiresAuthentication
    public String toMain() {
        return "main";
    }
    @GetMapping("/notLogin")
    public String notLogin() {
        return "login";
    }
    @GetMapping("/testShiroUtis")
    @ResponseBody
    public void testShiroUtis() {
        User user = ShiroUtils.getUser();
        System.out.println("testShiroUtis ShiroUtils.getUser() = " + user);
    }
}
