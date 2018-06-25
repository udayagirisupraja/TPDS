package com.bvrit.tpds.dto;

public class Feedback {
	private  String citizenFeedback;
	private String status;
	private Orderset transactionId;
		
	public Feedback() {}
	public Feedback(String CitizenFeedback,String status,int transactionId) {
		super();
		this.citizenFeedback=CitizenFeedback;
		this.status=status;
	}
	public String getCitizenFeedback() {
		return citizenFeedback;
	}
	public void setCitizenFeedback(String citizenFeedback) {
		this.citizenFeedback = citizenFeedback;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Orderset getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Orderset transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "feedback [CitizenFeedback=" + citizenFeedback + ", status=" + status + ", transactionId="
				+ transactionId + "]";
	}
}
	


