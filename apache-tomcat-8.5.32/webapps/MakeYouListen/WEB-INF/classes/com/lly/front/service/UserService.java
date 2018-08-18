package com.lly.front.service;

import java.util.List;

import com.lly.front.model.DaTi;
import com.lly.front.model.User;

/*
 * 用户服务
 */
public interface UserService {
	//插入微信用户基本数据信息
	Integer insertUserInfo(User user);
	//修改用户数据
	Integer alterUserInfo(User user);
	//查询某一个用户是否存在
	User selectUserByOpenid(User user);
	
	
	
	/*
	 * 答题系统
	 */
	Integer inserDatiUserInfo(DaTi dati);
	List<DaTi> showAllDatiInfo();
	
}
