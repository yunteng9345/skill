package com.lly.front.model;

public class Theme {
	private String tcontent;//主题内容
	private String ttime;//主题发布时间
	private String tclass;//主题类别
	private int tstar;//主题获赞数
	private int tid;;//主题唯一标识符
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public int getTstar() {
		return tstar;
	}
	public void setTstar(int tstar) {
		this.tstar = tstar;
	}
	
}
