package com.bvrit.tpds.dto;

public class FeedbackResponse {
//	private int serialNo;
	private Feedback transactionId;
	private String response;
	private String responseBy;
		
	public FeedbackResponse() {}
	
	public FeedbackResponse(int transactionId, String response, String responseBy) {
		super();
	//	this.serialNo = serialNo;
		this.response = response;
		this.responseBy = responseBy;
	}

 /*	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	} */

	public String getResponse() {
		return response;
	}
	public Feedback getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Feedback transactionId) {
		this.transactionId = transactionId;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	public String getResponseBy() {
		return responseBy;
	}
	public void setResponseBy(String responseBy) {
		this.responseBy = responseBy;
	}

	@Override
	public String toString() {
		return "feedbackResponse [transactionId=" + transactionId + ", response=" + response
				+ ", responseBy=" + responseBy + "]";
	}
	
}
