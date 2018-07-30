package com.lly.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lly.front.model.Theme;
import com.lly.front.serviceImp.ThemeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 主题前端控制器
 */
@Controller
@RequestMapping("/theme")
public class ThemeController {
	@Autowired
	private ThemeServiceImpl themeServiceImpl;

	public void setThemeServiceImpl(ThemeServiceImpl themeServiceImpl) {
		this.themeServiceImpl = themeServiceImpl;
	}
	/*
	 * 主题展示
	 */
	@ResponseBody
	@RequestMapping(value = "/showAllTheme", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String showAllTheme() {
		//查询到所有的主题
		List<Theme> themes =  themeServiceImpl.showAllTheme();
		//将list变成json数据
		JSONArray listArray = JSONArray.fromObject(themes);
		//创建一个json对象数组
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("themes", listArray);
		JSONObject jsonObject = JSONObject.fromObject(map);	
		
		System.out.println("主题显示成功！");
		return jsonObject.toString();
		
	}

}
