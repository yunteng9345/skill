package com.lly.front.service;

import java.util.List;

import com.lly.front.model.LoveComment;

public interface LoveCommentService {
	/*
	 * 表白墙回复功能
	 */
	//添加录音
		Integer insertLoveComment(LoveComment loveComment);
		//显示录音,根据主题的对应值
		List<LoveComment> selectLoveCommentByLno(LoveComment loveComment);
		

}
