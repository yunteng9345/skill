package com.lly.front.controller;

import java.io.File;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lly.front.model.LoveWall;
import com.lly.front.serviceImp.LoveWallServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/lovewall")
public class LoveWallController {
	@Autowired
	private LoveWallServiceImpl loveWallServiceImpl;

	public void setLoveWallServiceImpl(LoveWallServiceImpl loveWallServiceImpl) {
		this.loveWallServiceImpl = loveWallServiceImpl;
	}

	/**
	 * 表白发布
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public @ResponseBody void UserLogIn111(@RequestParam String openId, @RequestParam String textarea,
			@RequestParam String switch1, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		/*
		 * 基本数据
		 */
		//String textarea1 = new String(textarea.getBytes("ISO8859-1"), "UTF-8");
		LoveWall loveWall = new LoveWall();
		
		System.out.println(textarea);
		
		loveWall.setOpenid(openId);
		loveWall.setLcontent(textarea);
		loveWall.setIsShowName(switch1);
		// 设置时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		loveWall.setLtime(date);
		/*
		 * 提交文件
		 */
		// 添加录音文件到项目根文件下
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = req.getFile("picfile");

		// = "E:\\java_project\\MakeYouListen\\WebContent\\voices";
		File file00 = new File(LoveWall.class.getClassLoader().getResource("../../1.txt").getPath());
		String realPath1 = file00.getAbsolutePath();
		String realPath = realPath1.replace("1.txt", "pic/");

		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		UUID uuid = UUID.randomUUID();
		File file = new File(realPath, uuid + ".png");
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loveWall.setPicaddr(uuid + ".png");
		loveWallServiceImpl.insertintoLoveWall(loveWall);
		System.out.println("发布表白成功");

	}
	
	
	/*
	 * 表白展示
	 */
	@ResponseBody
	@RequestMapping(value = "/showAllLove", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String showAllTheme() {
		
		List<LoveWall> loves = loveWallServiceImpl.showAllLoveWall();
//		for(LoveWall l:loves) {
//			System.out.println(l.getLcontent());
//		}
		JSONArray listArray = JSONArray.fromObject(loves);
		//创建一个json对象数组
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allLoves", listArray);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("显示表白列表成功！");
		return jsonObject.toString();
		
	}

}
