package com.oracle.entity;

import java.util.Date;
//΢�ŵ�¼ʵ����
public class WechatAuth {
	// ����ID
	private Long wechatAuthId;
	// ΢�Ż�ȡ�û���Ϣ��ƾ֤������ĳ�����ںž���Ψһ��
	private String openId;
	// ����ʱ��
	private Date createTime;
	// �û���Ϣ
	private PersonInfo personInfo;

	public Long getWechatAuthId() {
		return wechatAuthId;
	}

	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
