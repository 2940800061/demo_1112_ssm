package com.demo.service.impl;

import javax.annotation.Resource;

import com.demo.database.data.TDemoRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.database.data.TDemoAccount;
import com.demo.database.mapper.IAccountMapper;
import com.demo.service.IUserService;

import java.sql.Timestamp;
import java.util.List;

/**
 * desc: 登录及注销业务实现类
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-11 15:40:22
 * @updateTime 2020-11-11 15:40:22
 */
@Service
public class UserServiceImpl implements IUserService {

    //注入数据访问接口对象
    @Resource
    private IAccountMapper iaccountMapper;

    @Override
    public String login(Model model, String account,
                        String password) throws Exception {
        //查询登录帐号，根据帐号、密码获得帐号对象
        TDemoAccount tdemoAccount = iaccountMapper.getAccountByLogin(account, password);
        System.out.println("===========");
        System.out.println(tdemoAccount);
        //验证用户是否可以登录
        if (tdemoAccount != null) {
            model.addAttribute("userInfo", tdemoAccount);
            return "index";
        }
        model.addAttribute("error", "用户名或密码错误!");
        return "login";
    }

    @Override
    public String logout(Model model,
                         SessionStatus sessionStatus) throws Exception {
        //model.addAttribute("userInfo", null);
        //销毁session对象
        //session.invalidate();
        //清理框架中Session缓存数据
        sessionStatus.setComplete();
        //重定向
        return "redirect:login.jsp";
    }

    @Override
    public String queryAll(String accountName, Model model, Integer pageNum) throws Exception {
        pageNum = pageNum == null ? 1 : pageNum;
        PageHelper.startPage(pageNum, 5);
        List<TDemoAccount> list = iaccountMapper.queryAll(accountName);
        PageInfo<TDemoAccount> pageInfo = new PageInfo(list, 10);
        model.addAttribute("list", list);
        model.addAttribute("pageInfo", pageInfo);
        return "pages/user/userlist";
    }

    @Override
    public String add(Model model, String accountName, String accountPassword, String accountGender) throws Exception {
        TDemoAccount account = new TDemoAccount();
        account.setAccountName(accountName);
        account.setAccountPassword(accountPassword);
        account.setAccountGender(accountGender);
        account.setOperTime(new Timestamp(System.currentTimeMillis()));
        //添加数据
        iaccountMapper.add(account);
        //更新数据列表

        return queryAll(null, model, 1);
    }

    @Override
    public void deleteById(Model model, Integer... ids) {
        iaccountMapper.deleteById(ids);
    }


    @Override
    public String queryById(Model model, Integer id) throws Exception {
        TDemoAccount account = iaccountMapper.queryById(id);

        model.addAttribute("account", account);

        return "pages/user/userupdate";
    }

    @Override
    public void updateUser(TDemoAccount account) throws Exception {
        iaccountMapper.updateUser(account);

    }

}
