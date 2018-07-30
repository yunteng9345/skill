package com.lly.front.model;

public class User {
	private String openid;//用户唯一识别标识
	private String session_key;//用户session_key
	private String uname;//用户微信名
	private String usex;//用户微信性别
	private int uage;//用户微信中的年龄
	private String uregtime;//用户第一次注册时间
	private String uschool;//所在学校
	private String uacademy;//所在院系
	private String uicon;//头像地址
	
	public String getUicon() {
		return uicon;
	}
	public void setUicon(String uicon) {
		this.uicon = uicon;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUregtime() {
		return uregtime;
	}
	public void setUregtime(String uregtime) {
		this.uregtime = uregtime;
	}
	public String getUschool() {
		return uschool;
	}
	public void setUschool(String uschool) {
		this.uschool = uschool;
	}
	public String getUacademy() {
		return uacademy;
	}
	public void setUacademy(String uacademy) {
		this.uacademy = uacademy;
	}
	
	

}
