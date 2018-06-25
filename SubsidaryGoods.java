package com.bvrit.tpds.dto;

public class SubsidaryGoods {
	private String name;
	private String qty;
	private Admin userName;
	private Double price;
	private Double priceFor;
	private int serialNo;
		
	public SubsidaryGoods () {}
	
	public SubsidaryGoods(String name, String qty, Admin userName, Double price, Double priceFor) {
		super();
		this.name = name;
	//	this.serialNo = serialNo;
		this.qty = qty;
		this.price = price;
		this.priceFor = priceFor;
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	} 

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Admin getUserName() {
		return userName;
	}

	public void setUserName(Admin userName) {
		this.userName = userName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceFor() {
		return priceFor;
	}

	public void setPriceFor(Double priceFor) {
		this.priceFor = priceFor;
	}

	@Override
	public String toString() {
		return "SubsidaryGoods [name=" + name + ", qty=" + qty + ", userName=" + userName + ", price=" + price
				+ ", priceFor=" + priceFor + ", serialNo=" + serialNo + "]";
	}
	
}
