package com.oracle.o2o.entity;

import java.util.Date;

/**
 * ������֤ʵ���࣬��Ҫ�������ʺ�����ĵ�¼
 *
 */
public class LocalAuth {
	// ����ID
	private Long localAuthId;
	// �ʺ�
	private String username;
	// ����
	private String password;
	// ����ʱ��
	private Date createTime;
	// ���һ�εĸ���ʱ��
	private Date lastEditTime;
	// ������Ϣ����ϵΪһһ��Ӧ
	private PersonInfo personInfo;

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}


}
