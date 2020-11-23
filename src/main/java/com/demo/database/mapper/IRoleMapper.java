package com.demo.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.demo.database.data.TDemoRole;

/**
 * desc: 角色数据访问接口
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-13 15:14:36
 * @updateTime 2020-11-13 15:14:36
 */
public interface IRoleMapper {

    /**
     * desc: 查询所有角色数据
     *
     * @return
     * @throws Exception
     */
    @Results(id = "roleSimpleResults", value = {
            @Result(property = "roleId", column = "role_id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "operUser", column = "oper_user"),
            @Result(property = "operTime", column = "oper_time"),
    })
    @Select("<script>"
            + "select role_id,role_name,oper_user,oper_time from t_demo_role"
            + "<where>"
            + "<if test=\"roleName != null and roleName != ''\">"
            + " role_name like '%${roleName}%'"
            + "</if>"
            + "</where>"
            + " order by oper_time desc"
            + "</script>")
    public List<TDemoRole> queryAll(@Param("roleName") String roleName) throws Exception;

    /**
     * desc:根据ID获得角色对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Results(id = "roleResults", value = {
            @Result(property = "roleId", column = "role_id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "TDemoPermissions", column = "role_id",
                    many = @Many(select = "com.demo.database.mapper.IPermissionMapper.getByRoleId"))
    })
    @Select("select role_id,role_name from t_demo_role where role_id=#{id}")
    public TDemoRole getById(Integer id) throws Exception;

    /**
     * desc: 添加角色数据
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into t_demo_role(role_name,oper_user,oper_time) values(#{roleName}, #{operUser}, #{operTime})")
    void add(TDemoRole role) throws Exception;

    /**
     * desc: 删除角色数据
     *
     * @param role
     * @throws Exception
     */
    @Delete("<script>"
            + "delete from t_demo_role where role_id in "
            + "<foreach item='id'  collection='array' "
            + "open='(' separator=',' close=')'>"
            + "#{id}"
            + "</foreach>"
            + "</script>")
    void deleteById(Integer... ids);

}
