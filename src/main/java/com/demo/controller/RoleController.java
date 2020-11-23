package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.demo.database.data.TDemoAccount;
import com.demo.service.IRoleService;

import java.util.Arrays;

/**
 * desc: 角色管理
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-18 9:37:59
 * @updateTime 2020-11-18 9:37:59
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    //注入业务实现接口对象
    @Resource
    private IRoleService iroleService;

    /**
     * desc: 查询角色
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("/query.do")
    public String query(Model model, String sroleName, Integer pageNum) {
        try {
            //访问业务实现接口的查询方法
            String nextPath = iroleService.query(model, sroleName, pageNum);
            //返回下一个视图路径
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * desc: 展示添加角色视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/addview.do")
    public String addView(Model model) {
        return "pages/role/roleadd";
    }

    /**
     * desc: 添加角色
     *
     * @param model
     * @param account
     * @param roleName
     * @return
     * @throws Exception
     */
    @RequestMapping("/add.do")
    public String add(Model model, @SessionAttribute("userInfo") TDemoAccount account, String roleName) throws Exception {
        try {
            String nextPath = iroleService.add(model, account, roleName);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/delete.do")
    public String deleteById(@RequestParam("ids") Integer[] ids, Model model
            , @RequestParam("roleName") String name
            , @RequestParam("pageNum") Integer pageNum) {

        try {
            iroleService.deleteById(model, ids);
            return query(model, name, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";

    }


}
