package com.lly.front.model;

public class LoveComment extends User {
	private int lcid;
	private int lno;
	private String lctime;
	private String lccontent;
	private String openid;
	public int getLcid() {
		return lcid;
	}
	public void setLcid(int lcid) {
		this.lcid = lcid;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getLctime() {
		return lctime;
	}
	public void setLctime(String lctime) {
		this.lctime = lctime;
	}
	public String getLccontent() {
		return lccontent;
	}
	public void setLccontent(String lccontent) {
		this.lccontent = lccontent;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	

}
