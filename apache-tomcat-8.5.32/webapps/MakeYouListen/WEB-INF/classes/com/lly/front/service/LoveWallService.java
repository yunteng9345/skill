package com.lly.front.service;

import java.util.List;

import com.lly.front.model.LoveWall;

public interface LoveWallService {
	//添加表白信息
	Integer insertintoLoveWall(LoveWall loveWall);
	//显示所有表白信息
	List<LoveWall> showAllLoveWall();
	//根据lno查询一条数据
	LoveWall selectLoveWallByLno(LoveWall loveWall);
	
}
