package com.bvrit.tpds.dto;

public class District {
	private String name;
	private String districtId;
	private Admin userName;
	
	
	public District() {}
	public District(String name, String districtId, Admin userName) {
		super();
		this.name = name;
		this.districtId = districtId;
		this.userName = userName;
	}
	
	public Admin getUserName() {
		return userName;
	}
	public void setUserName(Admin userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	@Override
	public String toString() {
		return "District [name=" + name + ", districtId=" + districtId + ", userName=" + userName + "]";
	}
	
}
	
	


