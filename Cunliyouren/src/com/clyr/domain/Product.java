package com.clyr.domain;

import java.sql.Timestamp;

public class Product {
	//��ƷID�ţ�������������
	private int pId;
	//��Ʒ����
	private String productName;
	//��Ʒ�۸�
	private double price;
	//��Ʒ������λ
	private String unit;
	//��Ʒ��������
	private String description;
	//��ƷͼƬ����1
	private String picture1;
	//��ƷͼƬ����2
	private String picture2;
	//��ƷͼƬ����3
	private String picture3;
	//��Ʒ���׵ص�
	private String deliveryPoint;
	//��Ʒ����ID
	private int ownerId;
	//��Ʒ��������ʱ��
	private Timestamp updateTime;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public String getPicture3() {
		return picture3;
	}
	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	public String getDeliveryPoint() {
		return deliveryPoint;
	}
	public void setDeliveryPoint(String deliveryPoint) {
		this.deliveryPoint = deliveryPoint;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}