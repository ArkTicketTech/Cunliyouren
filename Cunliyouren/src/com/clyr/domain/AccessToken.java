package com.clyr.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class AccessToken implements Serializable  {
	private static final long serialVersionUID = 5736758072147313375L;
	//
	private String accessToken;
	//
	private Timestamp createTime;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
