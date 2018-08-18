package com.lly.front.model;

public class LoveWall extends User {
	private String openid;
	private String ltime;
	private String lcontent;
	private String isShowName;
	private String picaddr;
	private int lno;
	
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getLtime() {
		return ltime;
	}
	public void setLtime(String ltime) {
		this.ltime = ltime;
	}
	public String getLcontent() {
		return lcontent;
	}
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}
	public String getIsShowName() {
		return isShowName;
	}
	public void setIsShowName(String isShowName) {
		this.isShowName = isShowName;
	}
	public String getPicaddr() {
		return picaddr;
	}
	public void setPicaddr(String picaddr) {
		this.picaddr = picaddr;
	}
	

	
}
