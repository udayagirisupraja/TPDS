package com.bvrit.tpds.dto;

public class Orderset {
	private Double amount;
	private String transactiondate;
	private String issueDate;
	private int year;
	private CitizenGoods transactionId;
	private String status;
		
	public Orderset() {}
	
	public Orderset(Double amount,String transactiondate,String issueDate,int year,int transactionId,String status) {
		super();
		this.amount=amount;
		this.transactiondate=transactiondate;
		this.issueDate=issueDate;
		this.year=year;
		this.status=status;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	

	public CitizenGoods getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(CitizenGoods transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orderset [amount=" + amount + ", transactiondate=" + transactiondate + ", issueDate=" + issueDate
				+ ", year=" + year + ", transactionId=" + transactionId + ", status=" + status + "]";
	}	
			
}
	