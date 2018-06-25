package com.bvrit.tpds.dto;

import java.util.Date;

public class FamilyMembers {
	
	private String aadharId;
	private String firstName;
	private String lastName;
	private int age;
	private Date dOB;
	private String gender;
	private String occupation;
	private Citizen Citizen_aadharId;
		
	public FamilyMembers() {}

	public FamilyMembers(String aadharId, String firstName, String lastName, int age, Date dOB, String gender,
			String occupation, Citizen citizen_aadharId) {
		super();
		this.aadharId = aadharId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dOB = dOB;
		this.gender = gender;
		this.occupation = occupation;
		Citizen_aadharId = citizen_aadharId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Citizen getCitizen_aadharId() {
		return Citizen_aadharId;
	}

	public void setCitizen_aadharId(Citizen citizen_aadharId) {
		Citizen_aadharId = citizen_aadharId;
	}

	@Override
	public String toString() {
		return "FamilyMembers [aadharId=" + aadharId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", dOB=" + dOB + ", gender=" + gender + ", occupation=" + occupation + ", Citizen_aadharId="
				+ Citizen_aadharId + "]";
	}


}
	
	


