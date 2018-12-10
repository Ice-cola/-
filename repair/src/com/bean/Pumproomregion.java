package com.bean;

public class Pumproomregion {
	private Integer pumproomregionid;
	private String regionname;
	public Pumproomregion(){
		
	}
	public Pumproomregion(Integer pumproomregionid,String regionname){
		this.pumproomregionid=pumproomregionid;
		this.regionname = regionname;
	}
	public Integer getPumproomregionid() {
		return pumproomregionid;
	}
	public void setPumproomregionid(Integer pumproomregionid) {
		this.pumproomregionid = pumproomregionid;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	@Override
	public String toString() {
		return "pumproomregion [pumproomregionid=" + pumproomregionid + ", regionname=" + regionname + "]";
	}
}
