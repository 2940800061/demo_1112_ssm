package com.demo.service.impl;

import java.sql.Timestamp;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.demo.database.data.TDemoAccount;
import com.demo.database.data.TDemoRole;
import com.demo.database.mapper.IRoleMapper;
import com.demo.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * desc: 角色管理业务实现类
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-18 9:46:03
 * @updateTime 2020-11-18 9:46:03
 */
@Service
public class RoleServiceImpl implements IRoleService {

    //注入数据访问映射接口对象
    @Resource
    private IRoleMapper iroleMapper;

    @Override
    public String query(Model model, String roleName, Integer pageNum) throws Exception {
        //判断是否获得页码
        pageNum = pageNum == null ? 1 : pageNum;
        //启用分页
        PageHelper.startPage(pageNum, 5);
        //查询角色数据
        List<TDemoRole> list = iroleMapper.queryAll(roleName);
        //获得分页相关信息
        PageInfo<TDemoRole> pageInfo = new PageInfo(list, 10);

        //封装模型数据
        model.addAttribute("list", list);
        model.addAttribute("pageInfo", pageInfo);
        return "pages/role/rolelist";
    }

    @Override
    public String add(Model model, TDemoAccount account, String roleName) throws Exception {
        //创建角色对象
        TDemoRole role = new TDemoRole();

        //封装角色数据
        role.setRoleName(roleName);
        role.setOperUser(account.getAccountName());
        role.setOperTime(new Timestamp(System.currentTimeMillis()));
        //添加角色数据
        iroleMapper.add(role);
        //更新数据列表
        return query(model, null, 1);
    }

    @Override
    public void deleteById(Model model, Integer... ids) throws Exception {
        iroleMapper.deleteById(ids);

    }
}
