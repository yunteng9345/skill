package com.lly.front.model;

public class Voice extends User{
	private String openid;//用户唯一标识符
	private String publishtime;//录音发布时间
	private String vaddr;//录音文件地址
	private String vtime;//录音时长
	private String tid;//主题唯一标识
	private String vid;//录音唯一标识符
	private String vtext;//录音中的文字
	
	public String getVtext() {
		return vtext;
	}
	public void setVtext(String vtext) {
		this.vtext = vtext;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public String getVaddr() {
		return vaddr;
	}
	public void setVaddr(String vaddr) {
		this.vaddr = vaddr;
	}
	public String getVtime() {
		return vtime;
	}
	public void setVtime(String vtime) {
		this.vtime = vtime;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
