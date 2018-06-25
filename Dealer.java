package com.bvrit.tpds.dto;

import java.util.Date;
public class Dealer {
	private String aadharId;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String emailId;
	private String gender;
	private Date dOB;
	private int age;
	private Ward wardId;
	private String photo;
	private String password;
	private String status;
	
	
	public Dealer() {}

	public Dealer(String aadharId, String firstName, String lastName, String phoneNo, String emailId, String gender,
			Date dOB, int age, Ward wardId, String photo,String password,String status) {
		super();
		this.aadharId = aadharId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.gender = gender;
		this.dOB = dOB;
		this.age = age;
		this.wardId = wardId;
		this.wardId = wardId;
		this.photo = photo;
		this.password = password;
		this.status = status;
	}
	public String getAadharId() {
		return aadharId;
	}
	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Ward getWardId() {
		return wardId;
	}

	public void setWardId(Ward wardId) {
		this.wardId = wardId;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Dealer [aadharId=" + aadharId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + ", emailId=" + emailId + ", gender=" + gender + ", dOB=" + dOB + ", age=" + age
				+ ", wardId=" + wardId + ", photo=" + photo + ", status=" + status + "]";
	}


}
