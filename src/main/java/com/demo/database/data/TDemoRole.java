package com.demo.database.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * desc: 角色表持久化类
 * @author weixianbo
 * @createTime 2020-11-13 14:49:07
 * @updateTime 2020-11-13 14:49:07
 * @version 1.0.0
 */
public class TDemoRole implements Serializable {

	private Integer roleId; // 角色ID
	private String roleName; // 角色名称
	//private List<TDemoAccount> TDemoAccounts;
	private List<TDemoPermission> TDemoPermissions; //关联权限的集合
	private String operUser; //操作人
	private Timestamp operTime; //操作时间

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<TDemoPermission> getTDemoPermissions() {
		return TDemoPermissions;
	}

	public void setTDemoPermissions(List<TDemoPermission> tDemoPermissions) {
		TDemoPermissions = tDemoPermissions;
	}

	public String getOperUser() {
		return operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}
	
}
