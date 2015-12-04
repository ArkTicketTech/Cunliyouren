package com.clyr.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable{
	private static final long serialVersionUID = -2100164975059774278L;
	//
	private int oId;
	//
	private int buyerId;
	//
	private int sellerId; 
	//
	private int productId;
	//
	private int pruductNumber;
	//
	private Timestamp createTime;
	
	public Order() {
		super();
		this.oId = 0;
		this.buyerId = 0;
		this.sellerId = 0;
		this.productId = 0;
		this.pruductNumber = 0;
		this.createTime = null;
	}
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPruductNumber() {
		return pruductNumber;
	}
	public void setPruductNumber(int pruductNumber) {
		this.pruductNumber = pruductNumber;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
}
