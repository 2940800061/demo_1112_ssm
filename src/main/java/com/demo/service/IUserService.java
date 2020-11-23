package com.demo.service;

import com.demo.database.data.TDemoAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * desc: 登录及注销业务接口
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-11 15:35:27
 * @updateTime 2020-11-11 15:35:27
 */
public interface IUserService {

    /**
     * desc: 登录
     *
     * @param model
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public String login(Model model, String account,
                        String password) throws Exception;

    /**
     * desc: 注销
     *
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    public String logout(Model model, SessionStatus sessionStatus) throws Exception;

    /**
     * 查询所有用户
     *
     * @param accountName
     * @return
     * @throws Exception
     */
    String queryAll(String accountName, Model model, Integer pageNum) throws Exception;

    /**
     * desc: 添加角色
     *
     * @param model
     * @param account
     * @param roleName
     * @return
     * @throws Exception
     */
    String add(Model model, String accountName, String accountPassword, String accountGender) throws Exception;

    void deleteById(Model model, Integer... ids) throws Exception;

    String queryById(Model model, Integer id) throws Exception;

    void updateUser(TDemoAccount account) throws Exception;
}
