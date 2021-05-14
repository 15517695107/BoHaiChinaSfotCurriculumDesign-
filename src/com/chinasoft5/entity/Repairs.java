package com.chinasoft5.entity;

public class Repairs {
	private String REid;
	private String Hid;
	private String STid;
	private String REdate;
	private String POSdate;
	private String REboolen;
	
	public Repairs(String rEid, String hid, String sTid, String rEdate, String pOSdate, String rEboolen) {
		super();
		REid = rEid;
		Hid = hid;
		STid = sTid;
		REdate = rEdate;
		POSdate = pOSdate;
		REboolen = rEboolen;
	}

	public Repairs() {
		super();
	}

	public String getREid() {
		return REid;
	}

	public void setREid(String rEid) {
		REid = rEid;
	}

	public String getHid() {
		return Hid;
	}

	public void setHid(String hid) {
		Hid = hid;
	}

	public String getSTid() {
		return STid;
	}

	public void setSTid(String sTid) {
		STid = sTid;
	}

	public String getREdate() {
		return REdate;
	}

	public void setREdate(String rEdate) {
		REdate = rEdate;
	}

	public String getPOSdate() {
		return POSdate;
	}

	public void setPOSdate(String pOSdate) {
		POSdate = pOSdate;
	}

	public String getREboolen() {
		return REboolen;
	}

	public void setREboolen(String rEboolen) {
		REboolen = rEboolen;
	}

	@Override
	public String toString() {
		return "Repairs [REid=" + REid + ", Hid=" + Hid + ", STid=" + STid + ", REdate=" + REdate + ", POSdate="
				+ POSdate + ", REboolen=" + REboolen + "]";
	}
	
	
}
