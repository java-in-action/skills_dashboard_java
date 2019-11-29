package com.acc.bean;

public class Employee {
	private int SysId;
	private String eId;
	private String name;
	private int Level;
	private String location;
	private String bithday;
	public int getSysId() {
		return SysId;
	}
	public void setSysId(int sysId) {
		SysId = sysId;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBithday() {
		return bithday;
	}
	public void setBithday(String bithday) {
		this.bithday = bithday;
	}
	
	
}
