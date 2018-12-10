package com.bean;

public class pumproom {
	private Integer PUMPROOM_ID;
	private String PUMPROOM_NAME;
	private Integer pumproomregionid;
	public pumproom(){}
	public pumproom(int PUMPROOM_ID,String PUMPROOM_NAME){
		this.PUMPROOM_ID = PUMPROOM_ID;
		this.PUMPROOM_NAME = PUMPROOM_NAME;
	}
	public Integer getPUMPROOM_ID() {
		return PUMPROOM_ID;
	}
	public void setPUMPROOM_ID(Integer pUMPROOM_ID) {
		PUMPROOM_ID = pUMPROOM_ID;
	}
	public String getPUMPROOM_NAME() {
		return PUMPROOM_NAME;
	}
	public void setPUMPROOM_NAME(String pUMPROOM_NAME) {
		PUMPROOM_NAME = pUMPROOM_NAME;
	}
	public Integer getPumproomregionid() {
		return pumproomregionid;
	}
	public void setPumproomregionid(Integer pumproomregionid) {
		this.pumproomregionid = pumproomregionid;
	}
	@Override
	public String toString() {
		return "pumproom [PUMPROOM_ID=" + PUMPROOM_ID + ", PUMPROOM_NAME=" + PUMPROOM_NAME + ", pumproomregionid="
				+ pumproomregionid + "]";
	}
	
}
