package com.demo.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * desc: 帐号持久化类
 * @author weixianbo
 * @createTime 2020-11-12 14:30:48
 * @updateTime 2020-11-12 14:30:48
 * @version 1.0.0
 */
public class TDemoAccount implements Serializable {

	private Integer accountId; //ID
	private String accountName; //帐号
	private String accountPassword; //密码
	private String accountGender; //性别
	private Timestamp operTime; //操作时间
	private TDemoRole TDemoRole; //角色

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getAccountGender() {
		return accountGender;
	}

	public void setAccountGender(String accountGender) {
		this.accountGender = accountGender;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

	public TDemoRole getTDemoRole() {
		return TDemoRole;
	}

	public void setTDemoRole(TDemoRole tDemoRole) {
		TDemoRole = tDemoRole;
	}

	@Override
	public String toString() {
		return "TDemoAccount{" +
				"accountId=" + accountId +
				", accountName='" + accountName + '\'' +
				", accountPassword='" + accountPassword + '\'' +
				", accountGender='" + accountGender + '\'' +
				", operTime=" + operTime +
				", TDemoRole=" + TDemoRole +
				'}';
	}
}
