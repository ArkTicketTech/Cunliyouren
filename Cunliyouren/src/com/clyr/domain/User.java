package com.clyr.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	private static final long serialVersionUID = 3452574737281967823L;
	//
	private int uId;
	//
	private String openId;
	//
	private String nickName;
	//
	private String accessToken;
	//
	private String headImgUrl;
	//
	private String telNum;
	//
	private String homeTown;
	//
	private String highSchool;
	//
	private String university;
	//
	private String homeAddress;
	//
	private String workingAddress;
	//
	private int state;

	private ArrayList<Integer> pid;

	private ArrayList<String> pName;

	private int sendOrder;

	private int receiveOrder;

	public User() {
		this.uId = 0;
		this.openId = "";
		this.nickName = "";
		this.accessToken = "";
		this.headImgUrl = "";
		this.telNum = "";
		this.homeTown = "";
		this.highSchool = "";
		this.university = "";
		this.homeAddress = "";
		this.workingAddress = "";
		this.state = 1;
		this.pid = null;
		this.sendOrder = 0;
		this.receiveOrder = 0;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getWorkingAddress() {
		return workingAddress;
	}

	public void setWorkingAddress(String workingAddress) {
		this.workingAddress = workingAddress;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getSendOrder() {
		return sendOrder;
	}

	public void setSendOrder(int sendOrder) {
		this.sendOrder = sendOrder;
	}

	public int getReceiveOrder() {
		return receiveOrder;
	}

	public void setReceiveOrder(int receiveOrder) {
		this.receiveOrder = receiveOrder;
	}

	public ArrayList<Integer> getPid() {
		return pid;
	}

	public void setPid(ArrayList<Integer> pid) {
		this.pid = pid;
	}

	public ArrayList<String> getpName() {
		return pName;
	}

	public void setpName(ArrayList<String> pName) {
		this.pName = pName;
	}
}
