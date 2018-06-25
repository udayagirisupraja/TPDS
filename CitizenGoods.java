package com.bvrit.tpds.dto;

public class CitizenGoods {
	private String productId;
	private String qty;
	private Double price;
	private Citizen aadharId;
	private DealerGoods serialNo;
	private int transactionId;
	private String productName;
	
	
	public CitizenGoods(){}
	public CitizenGoods(String productName,String productId,String qty,Double price,Citizen aadharId,DealerGoods serialNo) {
		super();
		this.productName=productName;
		this.productId=productId;
		this.qty=qty;
		this.price=price;
		this.aadharId=aadharId;
		this.serialNo=serialNo;
	}
		
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Citizen getAadharId() {
		return aadharId;
	}
	public void setAadharId(Citizen aadharId) {
		this.aadharId = aadharId;
	}
	public DealerGoods getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(DealerGoods serialNo) {
		this.serialNo = serialNo;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "citizenGoods [productId=" + productId + ", qty=" + qty + ", price=" + price + ", aadharId=" + aadharId
				+ ", serialNo=" + serialNo + ", transactionId=" + transactionId + ", productName=" + productName + "]";
	}
	
}
