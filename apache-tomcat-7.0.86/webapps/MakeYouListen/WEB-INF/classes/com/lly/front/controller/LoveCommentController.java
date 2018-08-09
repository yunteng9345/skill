package com.lly.front.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lly.front.model.LoveComment;
import com.lly.front.model.LoveWall;
import com.lly.front.serviceImp.LoveCommentImpl;
import com.lly.front.serviceImp.LoveWallServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/loveComment")
public class LoveCommentController {
	@Autowired
	private LoveCommentImpl loveCommentImpl;

	public void setLoveCommentImpl(LoveCommentImpl loveCommentImpl) {
		this.loveCommentImpl = loveCommentImpl;
	}
	@Autowired
	private LoveWallServiceImpl loveWallServiceImpl;

	public void setLoveWallServiceImpl(LoveWallServiceImpl loveWallServiceImpl) {
		this.loveWallServiceImpl = loveWallServiceImpl;
	}
	/*
	 * 添加表白墙回复信息
	 */
	@RequestMapping(value = "/addLoveComment", method = RequestMethod.GET)
	public void addVoicetext(@RequestParam String lccontent, @RequestParam String lno, @RequestParam String openId,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		
		LoveComment loveComment = new LoveComment();

		String lccontent1 = new String(lccontent.getBytes("ISO8859-1"), "UTF-8");
		
		//System.out.println(lccontent1);
		
		loveComment.setLccontent(lccontent1);
		loveComment.setLno(Integer.parseInt(lno));
		loveComment.setOpenid(openId);
		// 设置时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		loveComment.setLctime(date);
		
		
		loveCommentImpl.insertLoveComment(loveComment);
		System.out.println("回复表白墙内容成功");

	}

	/*
	 * 显示表白墙信息通过lno
	 */
	@RequestMapping(value = "/allLoveComment", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String selectLoveCommentByLno1(@RequestParam String lno) {
		LoveComment loveComment = new LoveComment();
		loveComment.setLno(Integer.parseInt(lno));
		//根据lno查询所评论信息
		//System.out.println(lno);
		List<LoveComment> loveList = loveCommentImpl.selectLoveCommentByLno(loveComment);
		JSONArray listArray = JSONArray.fromObject(loveList);
		//创建一个json对象数组
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allLoveComment", listArray);
		
		LoveWall loveWall = new LoveWall();
		loveWall.setLno(Integer.parseInt(lno));
		LoveWall loveWall2 = loveWallServiceImpl.selectLoveWallByLno(loveWall);
		JSONObject json = JSONObject.fromObject(loveWall2);
		map.put("loveWallTheme", json);
		
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("显示相应表白评论列表成功！");
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
		
	}

}
