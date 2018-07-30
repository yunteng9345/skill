package com.lly.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lly.front.model.DaTi;
import com.lly.front.model.LoveComment;
import com.lly.front.model.LoveWall;
import com.lly.front.serviceImp.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dati")
public class DatiController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	/*
	 * 插入答题人的姓名和时间 
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody void insertintoPerson(@RequestParam String name,@RequestParam String time,@RequestParam String branch) {
		int  time1= Integer.parseInt(time);
		DaTi dati = new DaTi();
		dati.setName(name);
		dati.setBranch(branch);
		dati.setTime(time1);
		userServiceImpl.inserDatiUserInfo(dati);
		System.out.println("插入答题人的信息成功！");

	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String showAllDati() {
		
		List<DaTi> list = userServiceImpl.showAllDatiInfo();
		JSONArray listArray = JSONArray.fromObject(list);
		//创建一个json对象数组
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allDati", listArray);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("显示排名信息成功！");
		return jsonObject.toString();
		
		
	}
	
		
	
		

}
