package com.ymw.mybatisplus.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @description:
 * @author: ymingwang
 * @create: 2019-06-13 17:49
 **/
@Controller
public class KaptchaController {

    /*-
    验证码工具
     */
    @Autowired
    DefaultKaptcha defaultKaptcha;

    /**
     * @return
     * @Description 生成验证码
     * @Author ymingwang
     * @Date 2019/6/13 0013 17:54
     * @Param [httpServletRequest, httpServletResponse]
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengenAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生成验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("rightCode", createText);
            //使产生的验证码字符串返回一个Buffereddlmage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengenAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengenAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * @return
     * @Description 校验验证码
     * @Author ymingwang
     * @Date 2019/6/13 0013 18:27
     * @Param [request, response]
     */
    @RequestMapping("/imgvrifyControllerDefalutKaptcha")
    public ModelAndView imgvrifyControllerDefalutKaptcha(HttpServletRequest request,
                                                         HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        String rightCode = (String) request.getSession().getAttribute("rightCode");
        String tryCode = request.getParameter("tryCode");

        if (!rightCode.equals(tryCode)) {
            view.addObject("info:", "错误的验证码");
            view.setViewName("index");
        } else {
            view.addObject("info", "登录成功");
            view.setViewName("success");
//            view.getViewName();
            System.out.println("~~~~rightCode:" + rightCode + "_____" + tryCode);
        }
        return view;
    }

    @PostMapping("/validateCode")
    @ResponseBody
    public String validateCode(HttpServletRequest request, ModelMap mmp) {

        String rightCode = (String) request.getSession().getAttribute("rightCode");
        String tryCode = request.getParameter("tryCode");
        if (!rightCode.equals(tryCode)) {
            System.out.println("验证码错误~~~~rightCode:" + rightCode + "_____" + "````tryCode: " +tryCode);
            return "false";
        } else {
            System.out.println("验证通过 ~~~~rightCode:" + rightCode + "_____" + "````tryCode: " + tryCode);
        }
        return "true";
    }


}
