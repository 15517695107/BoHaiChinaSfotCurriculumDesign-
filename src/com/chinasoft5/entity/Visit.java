package com.chinasoft5.entity;

/**
 * 拜访记录实体类
 * @author 86155
 * 2021-05-04 15:56:29
 */
public class Visit {
	private String Vid;
	private String Vname;
	private String STid;
	private String Vphone;
	private String Vintime;
	private String Vouttime;
	
	public Visit(String vid, String vname, String sTid, String vphone, String vintime, String vouttime) {
		super();
		Vid = vid;
		Vname = vname;
		STid = sTid;
		Vphone = vphone;
		Vintime = vintime;
		Vouttime = vouttime;
	}
	public Visit() {
		super();
	}
	
	public String getVid() {
		return Vid;
	}
	public void setVid(String vid) {
		Vid = vid;
	}
	public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}
	public String getSTid() {
		return STid;
	}
	public void setSTid(String sTid) {
		STid = sTid;
	}
	public String getVphone() {
		return Vphone;
	}
	public void setVphone(String vphone) {
		Vphone = vphone;
	}
	public String getVintime() {
		return Vintime;
	}
	public void setVintime(String vintime) {
		Vintime = vintime;
	}
	public String getVouttime() {
		return Vouttime;
	}
	public void setVouttime(String vouttime) {
		Vouttime = vouttime;
	}
	
	@Override
	public String toString() {
		return "Visit [Vid=" + Vid + ", Vname=" + Vname + ", STid=" + STid + ", Vphone=" + Vphone + ", Vintime="
				+ Vintime + ", Vouttime=" + Vouttime + "]";
	}
	
}
