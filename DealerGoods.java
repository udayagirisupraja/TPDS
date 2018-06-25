package com.bvrit.tpds.dto;

public class DealerGoods {
	private String productName;
	private String productId;
	private String qty;
	private Double price;
	private Dealer aadharId;
	private Double priceFor;
	private int serialNo;
		
	public DealerGoods() {}
	public DealerGoods(String productName, String productId, String qty, Double price, Dealer aadharId,Double priceFor) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.qty = qty;
		this.price = price;
		this.priceFor = priceFor;
		this.aadharId = aadharId;
	//	this.serialNo = serialNo;
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
	
	public Dealer getAadharId() {
		return aadharId;
	}
	public void setAadharId(Dealer aadharId) {
		this.aadharId = aadharId;
	}
	public Double getPriceFor() {
		return priceFor;
	}
	public void setPriceFor(Double priceFor) {
		this.priceFor = priceFor;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	@Override
	public String toString() {
		return "DealerGoods [productName=" + productName + ", productId=" + productId + ", qty=" + qty + ", price="
				+ price + ", Dealer_aadharId=" + aadharId + ", priceFor=" + priceFor +  "]";
	}

}
