package com.clyr.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2100164975059774278L;
	//订单ID号,主键，自增长
	private int oId;
	//买家id
	private int buyerId;
	//卖家id
	private int sellerId; 
	//订购产品id
	private int productId;
	//订购产品数量
	private int pruductNumber;
	//订单生成时间
	private Timestamp createTime;
	
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
