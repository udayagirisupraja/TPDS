package com.bvrit.tpds.dto;

public class Ward {
	private String name;
	private String wardId;
	private District districtId;
	
	public Ward () {}
	
	public Ward (String name,String wardId,String districtId) {
		super();
		this.name=name;
		this.wardId=wardId;
	}
	
	public District getDistrictId() {
		return districtId;
	}

	public void setDistrictId(District districtId) {
		this.districtId = districtId;
	}

	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public String getwardId() {
		return wardId;
	}
	public void setwardId(String wardId) {
		this.wardId=wardId;
	}
	
	@Override
	public String toString() {
		return "ward [name=" + name + ", wardId=" + wardId + ", districtId=" + districtId + "]";
	}
	
}


