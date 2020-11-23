package com.demo.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.demo.database.data.TDemoPermission;

/**
 * desc: 权限数据访问接口
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-16 9:29:27
 * @updateTime 2020-11-16 9:29:27
 */
public interface IPermissionMapper {

    /**
     * desc: 获得角色的权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Results(id = "permissionResults", value = {
            @Result(property = "permId", column = "perm_id", id = true),
            @Result(property = "permParentId", column = "perm_parent_id"),
            @Result(property = "permName", column = "perm_name"),
            @Result(property = "permUrl", column = "perm_url"),
            @Result(property = "permOrder", column = "perm_order")
    })
    @Select("select p.perm_id,perm_name,perm_url,perm_parent_id,perm_order from t_demo_role_permission rp join " +
			"t_demo_permission"
            + " p on rp.role_id=#{roleId} and rp.perm_id=p.perm_id order by perm_order")
    public List<TDemoPermission> getByRoleId(Integer roleId) throws Exception;

}
