package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.service.IUserService;

/**
 * desc: 登录及注销控制器
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-11 15:33:55
 * @updateTime 2020-11-11 15:33:55
 */
@Controller
@SessionAttributes({"userInfo"})
public class LoginController {

    //注入业务接口Bean对象
    @Resource
    private IUserService loginService;

    /**
     * desc: 登录
     *
     * @param model
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login.do")
    public String login(Model model, String account, String password) {
        try {
            String nextPath = loginService.login(
                    model, account, password);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "error";
    }

    /**
     * desc: 注销
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(Model model, SessionStatus sessionStatus,
                         RedirectAttributes attributes) {
        try {
            return loginService.logout(model, sessionStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";


    }

    @RequestMapping(value = "/getsessiondata.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getSessionData(@SessionAttribute String userInfo) {

        return "userInfo: " + userInfo;
    }

}










