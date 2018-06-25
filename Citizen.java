package com.bvrit.tpds.dto;

import java.util.Date;

public class Citizen {
	private String aadharId;
	private String firstName;
	private String lastName;
	private Double income;
	private String phoneNo;
	private String emailId;
	private Date dOB;
	private int age;
	private String gender;
	private int noOfFamilyMembers;
	private String occupation;
	private String photo;
	private String password;
	private String status;
	private String wardId;

	public Citizen() {
	}

	public Citizen(String aadharId, String firstName, String lastName, Double income, String phoneNo, String emailId,
			Date dOB, int age, String gender, int noOfFamilyMembers, String occupation, String photo, String password,
			String status, String wardId) {
		super();
		this.aadharId = aadharId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.income = income;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.dOB = dOB;
		this.age = age;
		this.gender = gender;
		this.noOfFamilyMembers = noOfFamilyMembers;
		this.occupation = occupation;
		this.photo = photo;
		this.password = password;
		this.status = status;
		this.wardId = wardId;
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

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoOfFamilyMembers() {
		return noOfFamilyMembers;
	}

	public void setNoOfFamilyMembers(int noOfFamilyMembers) {
		this.noOfFamilyMembers = noOfFamilyMembers;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	@Override
	public String toString() {
		return "Citizen [aadharId=" + aadharId + ", firstName=" + firstName + ", lastName=" + lastName + ", income="
				+ income + ", phoneNo=" + phoneNo + ", emailId=" + emailId + ", dOB=" + dOB + ", age=" + age
				+ ", gender=" + gender + ", noOfFamilyMembers=" + noOfFamilyMembers + ", occupation=" + occupation
				+ ", photo=" + photo + ", password=" + password + ", status=" + status + ", wardId=" + wardId + "]";
	}

	
}
