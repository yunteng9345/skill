package com.lly.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.lly.front.model.Notice;

import com.lly.front.serviceImp.NoticeServiceImpl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 录音前端控制器
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeServiceImpl noticeServiceImpl;

	
	public void setNoticeServiceImpl(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}

	/*
	 * 显示所有通知
	 */
	@RequestMapping(value = "/allNotices", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	
	public @ResponseBody String allMessage() {
		
		
		
			List<Notice> noticelist = noticeServiceImpl.showAllNotice();
			JSONArray listArray = JSONArray.fromObject(noticelist);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("notices", listArray);
			
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("显示通知列表成功！");
			return jsonObject.toString();
			
		
	}

}
