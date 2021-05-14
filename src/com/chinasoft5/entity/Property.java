package com.chinasoft5.entity;

public class Property {
	private String Pid;
	private String Hid;
	private String STid;
	private String Pdate;
	private String PEdate;
	private String Pboolen;
	
	public Property(String pid, String hid, String sTid, String pdate, String pEdate, String pboolen) {
		super();
		Pid = pid;
		Hid = hid;
		STid = sTid;
		Pdate = pdate;
		PEdate = pEdate;
		Pboolen = pboolen;
	}

	public Property() {
		super();
	}

	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		Pid = pid;
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

	public String getPdate() {
		return Pdate;
	}

	public void setPdate(String pdate) {
		Pdate = pdate;
	}

	public String getPEdate() {
		return PEdate;
	}

	public void setPEdate(String pEdate) {
		PEdate = pEdate;
	}

	public String getPboolen() {
		return Pboolen;
	}

	public void setPboolen(String pboolen) {
		Pboolen = pboolen;
	}

	@Override
	public String toString() {
		return "Property [Pid=" + Pid + ", Hid=" + Hid + ", STid=" + STid + ", Pdate=" + Pdate + ", PEdate=" + PEdate
				+ ", Pboolen=" + Pboolen + "]";
	}
	
}
