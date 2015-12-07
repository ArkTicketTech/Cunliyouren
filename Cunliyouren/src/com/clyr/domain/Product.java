package com.clyr.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Product implements Serializable {
	private static final long serialVersionUID = 7143998790200689098L;
	//
	private int pId;
	//
	private String productName;
	//
	private double price;
	//
	private String unit;
	//
	private String description;
	//
	private String picture1;
	//
	private String picture2;
	//
	private String picture3;
	//
	private String deliveryPoint;
	//
	private int ownerId;
	//
	private Timestamp updateTime;

	public Product() {
		super();
		this.pId = 0;
		this.productName = "";
		this.price = 0;
		this.unit = "";
		this.description = "";
		this.picture1 = "";
		this.picture2 = "";
		this.picture3 = "";
		this.deliveryPoint = "";
		this.ownerId = 0;
		this.updateTime = null;
	}

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
