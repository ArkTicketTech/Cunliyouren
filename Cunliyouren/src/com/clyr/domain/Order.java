package com.clyr.domain;

public class Order {
	//����ID��,������������
	private int oId;
	//���id
	private int buyerId;
	//����id
	private int sellerId; 
	//������Ʒid
	private int productId;
	//������Ʒ����
	private int pruductNumber;
	//��������ʱ��
	private String createTime;
	
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
}
