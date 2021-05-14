package com.chinasoft5.entity;

/**
 * 员工实体类
 * @author HanY
 * 2021-05-04 15:56:29
 */
public class Staff {
	private String STid;
	private String Sname;
	private String Susername;
	private String Spassword;
	private String Ssex;
	private String Sphone;
	private String Sintime;
	private String Sposition;
	
	//Constructor
	public Staff(String sTid, String sname, String susername, String spassword, String ssex, String sphone,
			String sintime, String sposition) {
		super();
		STid = sTid;
		Sname = sname;
		Susername = susername;
		Spassword = spassword;
		Ssex = ssex;
		Sphone = sphone;
		Sintime = sintime;
		Sposition = sposition;
	}

	public Staff() {
		super();
	}

	public String getSTid() {
		return STid;
	}

	public void setSTid(String sTid) {
		STid = sTid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSusername() {
		return Susername;
	}

	public void setSusername(String susername) {
		Susername = susername;
	}

	public String getSpassword() {
		return Spassword;
	}

	public void setSpassword(String spassword) {
		Spassword = spassword;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String ssex) {
		Ssex = ssex;
	}

	public String getSphone() {
		return Sphone;
	}

	public void setSphone(String sphone) {
		Sphone = sphone;
	}

	public String getSintime() {
		return Sintime;
	}

	public void setSintime(String sintime) {
		Sintime = sintime;
	}

	public String getSposition() {
		return Sposition;
	}

	public void setSposition(String sposition) {
		Sposition = sposition;
	}

	@Override
	public String toString() {
		return "Staff [STid=" + STid + ", Sname=" + Sname + ", Susername=" + Susername + ", Spassword=" + Spassword
				+ ", Ssex=" + Ssex + ", Sphone=" + Sphone + ", Sintime=" + Sintime + ", Sposition=" + Sposition + "]";
	}
	

	
}
