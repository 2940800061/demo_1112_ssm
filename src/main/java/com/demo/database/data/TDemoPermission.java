package com.demo.database.data;

import java.io.Serializable;
import java.util.List;

/**
 * desc: 权限表持久化类
 * @author weixianbo
 * @createTime 2020-11-16 9:19:26
 * @updateTime 2020-11-16 9:19:26
 * @version 1.0.0
 */
public class TDemoPermission implements Serializable {

	private Integer permId; //权限ID
	private Integer permParentId; //权限父级ID
	private String permName; //权限名称
	private String permUrl; //访问路径
	private String permOrder; //权限节点顺序
	private List<TDemoRole> TDemoRoles; //关联角色的集合

	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}
	
	public String getPermUrl() {
		return permUrl;
	}

	public void setPermUrl(String permUrl) {
		this.permUrl = permUrl;
	}

	public List<TDemoRole> getTDemoRoles() {
		return TDemoRoles;
	}

	public void setTDemoRoles(List<TDemoRole> tDemoRoles) {
		TDemoRoles = tDemoRoles;
	}

	public Integer getPermParentId() {
		return permParentId;
	}

	public void setPermParentId(Integer permParentId) {
		this.permParentId = permParentId;
	}

	public String getPermOrder() {
		return permOrder;
	}

	public void setPermOrder(String permOrder) {
		this.permOrder = permOrder;
	}
	
}
