package com.clyr.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7143998790200689098L;
	//产品ID号，主键，自增长
	private int pId;
	//产品名称
	private String productName;
	//产品价格
	private double price;
	//产品计量单位
	private String unit;
	//产品文字描述
	private String description;
	//产品图片描述1
	private String picture1;
	//产品图片描述2
	private String picture2;
	//产品图片描述3
	private String picture3;
	//产品交易地点
	private String deliveryPoint;
	//产品卖家ID
	private int ownerId;
	//产品最晚更新时间
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
