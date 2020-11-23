package com.demo.service;

import org.springframework.ui.Model;

import com.demo.database.data.TDemoAccount;

/**
 * desc: 角色管理业务接口
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-18 9:42:43
 * @updateTime 2020-11-18 9:42:43
 */
public interface IRoleService {


    /**
     * desc: 查询角色
     *
     * @param model
     * @param roleName
     * @param pageNum
     * @return
     * @throws Exception
     */
    String query(Model model, String roleName, Integer pageNum) throws Exception;

    /**
     * desc: 添加角色
     *
     * @param model
     * @param account
     * @param roleName
     * @return
     * @throws Exception
     */
    public String add(Model model, TDemoAccount account, String roleName) throws Exception;


    public void deleteById(Model model, Integer... ids) throws Exception;
}
