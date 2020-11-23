package com.demo.controller;

import com.demo.database.data.TDemoAccount;
import com.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


/**
 * @author ：周熹
 * @date ：Created in 2020/11/18 18:47
 * @modified By：
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/query.do")
    String query(String accountName, Model model, Integer pageNum) {
        try {
            return userService.queryAll(accountName, model, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/addview.do")
    public String addView() {
        return "/pages/user/useradd";
    }

    @RequestMapping("/add.do")
    public String add(@RequestParam("accountName") String accountName,
                      @RequestParam("accountPassword") String accountPassword,
                      @RequestParam("accountGender") String accountGender
            , Model model) throws Exception {
        try {
            return userService.add(model, accountName, accountPassword, accountGender);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * desc: 展示修改角色视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/updateview.do")
    public String updateView(Model model, @RequestParam("id") Integer id) {
        try {
            return userService.queryById(model, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/update.do")
    public String update(TDemoAccount account, Model model) {
        try {
            userService.updateUser(account);
            return query(null, model, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/delete.do")
    public String deleteById(@RequestParam("ids") Integer[] ids
            , @RequestParam("accountName") String name
            , @RequestParam("pageNum") Integer pageNum
            , Model model) {
        try {
            userService.deleteById(model, ids);
            return query(name, model, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }


}

