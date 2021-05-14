package com.chinasoft5.entity;
/**
 * 住户实体类
 * @author HanY
 * 2021-05-04 10:56:56
 */
public class Resident {
	private String Rid;
	private String Rname;
	private String Hid;
	private String Rusername;
	private String Rpassword;
	private String Rsex;
	private String Rphone;
	private String Rintime;
	private String Rowner;
	public Resident(String rid, String rname, String hid, String rusername, String rpassword, String rsex,
			String rphone, String rintime, String rowner) {
		super();
		Rid = rid;
		Rname = rname;
		Hid = hid;
		Rusername = rusername;
		Rpassword = rpassword;
		Rsex = rsex;
		Rphone = rphone;
		Rintime = rintime;
		Rowner = rowner;
	}
	public Resident() {
		super();
	}
	public String getRid() {
		return Rid;
	}
	public void setRid(String rid) {
		Rid = rid;
	}
	public String getRname() {
		return Rname;
	}
	public void setRname(String rname) {
		Rname = rname;
	}
	public String getHid() {
		return Hid;
	}
	public void setHid(String hid) {
		Hid = hid;
	}
	public String getRusername() {
		return Rusername;
	}
	public void setRusername(String rusername) {
		Rusername = rusername;
	}
	public String getRpassword() {
		return Rpassword;
	}
	public void setRpassword(String rpassword) {
		Rpassword = rpassword;
	}
	public String getRsex() {
		return Rsex;
	}
	public void setRsex(String rsex) {
		Rsex = rsex;
	}
	public String getRphone() {
		return Rphone;
	}
	public void setRphone(String rphone) {
		Rphone = rphone;
	}
	public String getRintime() {
		return Rintime;
	}
	public void setRintime(String rintime) {
		Rintime = rintime;
	}
	public String getRowner() {
		return Rowner;
	}
	public void setRowner(String rowner) {
		Rowner = rowner;
	}
	@Override
	public String toString() {
		return "Resident [Rid=" + Rid + ", Rname=" + Rname + ", Hid=" + Hid + ", Rusername=" + Rusername
				+ ", Rpassword=" + Rpassword + ", Rsex=" + Rsex + ", Rphone=" + Rphone + ", Rintime=" + Rintime
				+ ", Rowner=" + Rowner + "]";
	}
	
	
	
	
}
