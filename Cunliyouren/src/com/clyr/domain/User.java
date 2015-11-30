package com.clyr.domain;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3452574737281967823L;
	//�û�id��������������
	private int uId;
	//΢��ƽ̨�ṩӦ�����û�Ψһ��ʶ
	private String openId;
	//΢��ƽ̨�û��ǳ�
	private String nickName;
	//΢��ƽ̨�ṩ���ں����û�Ψһ��ʶ
	private String unionId;
	//�û�΢��ͷ��ͨ������΢���ṩ��url��ͼƬ�����ڱ���
	private String headImgUrl;
	//�û��ֻ��� ѡ��
	private String telNum;
	//�û�����
	private String homeTown;
	//�û�����
	private String highSchool;
	//�û���ѧ
	private String University;
	//�û���ס��ַ
	private String homeAddress;
	//�û�������ַ
	private String workingAddress;
	//�û�״̬ 0��ʾͣ�� 1��ʾ����
	private int state;
	
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
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
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
		return University;
	}
	public void setUniversity(String university) {
		University = university;
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
}
