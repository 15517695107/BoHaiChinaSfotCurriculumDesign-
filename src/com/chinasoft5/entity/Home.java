package com.chinasoft5.entity;
/**
 * 房屋实体类
 * @author HanY
 *2021-05-04 11:01:37
 */
public class Home {
	private String Hid;
	private double Harea;
	private String Hsite;
	//Constructor
	public Home(String hid, double harea, String hsite) {
		super();
		Hid = hid;
		Harea = harea;
		Hsite = hsite;
	}
	public Home() {
		super();
	}
	
	//Getters & Setters
	public String getHid() {
		return Hid;
	}
	public void setHid(String hid) {
		Hid = hid;
	}
	public double getHarea() {
		return Harea;
	}
	public void setHarea(double harea) {
		Harea = harea;
	}
	public String getHsite() {
		return Hsite;
	}
	public void setHsite(String hsite) {
		Hsite = hsite;
	}
	
	//重写toString
	@Override
	public String toString() {
		return "Home [Hid=" + Hid + ", Harea=" + Harea + ", Hsite=" + Hsite + "]";
	}
	

	
}
