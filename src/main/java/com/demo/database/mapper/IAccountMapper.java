package com.demo.database.mapper;

import org.apache.ibatis.annotations.*;

import com.demo.database.data.TDemoAccount;

import java.util.List;

/**
 * desc: 帐号数据访问接口
 *
 * @author weixianbo
 * @version 1.0.0
 * @createTime 2020-11-12 14:40:21
 * @updateTime 2020-11-12 14:40:21
 */
public interface IAccountMapper {

    /**
     * desc: 登录验证时，获得帐号数据对象
     *
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    @Results(id = "accountResults", value = {
            @Result(property = "accountId", column = "account_id", id = true),
            @Result(property = "accountName", column = "account_name"),
            @Result(property = "accountPassword", column = "account_password"),
            @Result(property = "accountGender", column = "account_gender"),
            @Result(property = "operTime", column = "oper_time"),
            @Result(property = "TDemoRole", column = "role_id", one = @One(
                    resultMap = "com.demo.database.mapper.IRoleMapper.roleResults"))
    })
    @Select("select account_id,account_name,account_password,account_gender,a.oper_time,a.role_id,role_name"
            + " from t_demo_account a join t_demo_role r on a.role_id=r.role_id"
            + " where account_name=#{account} and account_password=#{password}")
    TDemoAccount getAccountByLogin(@Param("account") String account,
                                   @Param("password") String password) throws Exception;


    @ResultMap("accountResults")
    @Select("<script>"
            + "select account_id,account_name,account_password,account_gender,oper_time from t_demo_account"
            + "<where>"
            + "<if test=\"accountName!=null and accountName!='' \">"
            + "account_name like '%${accountName}%'"
            + "</if>"
            + "</where>"
            + "order by oper_time desc"
            + "</script>")
    List<TDemoAccount> queryAll(@Param("accountName") String accountName) throws Exception;


    @Insert("insert into t_demo_account(account_name,account_password,account_gender,oper_time)" +
            " values (#{accountName},#{accountPassword},#{accountGender},#{operTime})")
    void add(TDemoAccount account);


    @Select("select account_id,account_name,account_password,account_gender,oper_time,role_id"
            + " from t_demo_account where account_id=#{id}")
    @ResultMap("accountResults")
    TDemoAccount queryById(Integer id);


    @Update("update t_demo_account set account_name=#{accountName},"
            + "account_password=#{accountPassword},"
            + "account_gender=#{accountGender}"
            + " where account_id=#{accountId}")
    void updateUser(TDemoAccount account);

    @Delete("<script>"
            + "delete from t_demo_account where account_id in "
            + "<foreach item='id'  collection='array' "
            + "open='(' separator=',' close=')'>"
            + "#{id}"
            + "</foreach>"
            + "</script>")
    void deleteById(Integer... ids);
}
