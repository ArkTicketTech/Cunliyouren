package com.clyr.domain;

public class RelationBean {
	String friendName;
	int hometown;
	int school;
	int homeAdd;
	int workAdd;
	public RelationBean() {
		super();
		this.friendName = "";
		this.hometown = 0;
		this.school = 0;
		this.homeAdd = 0;
		this.workAdd = 0;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public int getHometown() {
		return hometown;
	}
	public void setHometown(int hometown) {
		this.hometown = hometown;
	}
	public int getSchool() {
		return school;
	}
	public void setSchool(int school) {
		this.school = school;
	}
	public int getHomeAdd() {
		return homeAdd;
	}
	public void setHomeAdd(int homeAdd) {
		this.homeAdd = homeAdd;
	}
	public int getWorkAdd() {
		return workAdd;
	}
	public void setWorkAdd(int workAdd) {
		this.workAdd = workAdd;
	}
	
}
