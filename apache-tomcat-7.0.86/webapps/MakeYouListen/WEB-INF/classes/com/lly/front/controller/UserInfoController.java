package com.lly.front.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lly.front.model.User;
import com.lly.front.serviceImp.UserServiceImpl;
import com.lly.front.tools.MyX509TrustManager;


import net.sf.json.JSONObject;

/*
 * 用户信息前端控制器
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	/**
	 * 微信用户登录
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody String UserLogIn(@RequestParam String uicon,@RequestParam String codes, @RequestParam String encryptedDatas,
			@RequestParam String ivs, @RequestParam String username, @RequestParam String usersex,
			HttpServletRequest request) throws UnsupportedEncodingException {
		
		String username1 = new String(username.getBytes("ISO8859-1"),"UTF-8");
		//System.out.println(username1);
		String usersex1 = new String(usersex.getBytes("ISO8859-1"),"UTF-8");
		//System.out.println(usersex1);
		 
		String AppID = "wxff425d77fca37242";// 小程序id
		String AppSecret = "7972f8b21bb5bacaee90c5a78f4b57e6";// 小程序secret
		String requestURL = "https://api.weixin.qq.com/sns/jscode2session?appid=" + AppID + "&secret=" + AppSecret
				+ "&js_code=" + codes + "&grant_type=authorization_code";
		String string = MyX509TrustManager.httpsRequest(requestURL, "POST", null);
		JSONObject json = JSONObject.fromObject(string);
		//设置时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

		
		//第一次登陆存session
		//HttpSession session = request.getSession();  
		//String sessionId = session.getId();  
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("openId", json.getString("openid"));
		User user = new User();
		//System.out.println(json.toString());
		user.setOpenid(json.getString("openid"));
		user.setSession_key(json.getString("session_key"));
		//System.out.println(user.getSession_key());
		user.setUname(username1);
		user.setUsex(usersex1);
		//System.out.println(uicon);
		user.setUicon(uicon);
		user.setUregtime(date);
		User user2 = userServiceImpl.selectUserByOpenid(user);	
		//request.getSession(true).setAttribute("now_user", user);		
		// 判断是否是第一次登录
		if (user2 == null) {
			userServiceImpl.insertUserInfo(user);
			System.out.println("新用户   " + username1 + "  添加成功！");

		} else {

			System.out.println("该用户  " + username1 + "  已经存在！");
			
			
		}
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
	
	/*
	 * 微信用户信息修改
	 */
	@RequestMapping(value = "/login/alterUserInfo", method = RequestMethod.GET)
	public @ResponseBody void UserAlter(@RequestParam String openId,@RequestParam String username, @RequestParam String usersex,
			@RequestParam String userage, @RequestParam String userschool, @RequestParam String useracademy,
			HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		
		String username1 = new String(username.getBytes("ISO8859-1"),"UTF-8");
		String usersex1 = new String(usersex.getBytes("ISO8859-1"),"UTF-8");
		String userschool1 = new String(userschool.getBytes("ISO8859-1"),"UTF-8");
		String useracademy1 = new String(useracademy.getBytes("ISO8859-1"),"UTF-8");
		
		User user = new User();
		user.setUname(username1);
		user.setUsex(usersex1);
		user.setUage(Integer.parseInt(userage));
		user.setUschool(userschool1);
		user.setUacademy(useracademy1);
		user.setOpenid(openId);
		
		userServiceImpl.alterUserInfo(user);
		System.out.println("更新用户数据成功！");

	}
	/*
	 * 微信详细信息展示
	 */
	@RequestMapping(value = "/showUserDetail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String UserShowDetail(@RequestParam String openId) throws UnsupportedEncodingException {
		User user = new User();
		user.setOpenid(openId);
		User user1 = userServiceImpl.selectUserByOpenid(user);
		JSONObject json = JSONObject.fromObject(user1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userDetail", json);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("显示用户细节成功！");
		System.out.println(json.toString());
		return jsonObject.toString();

	}

}
