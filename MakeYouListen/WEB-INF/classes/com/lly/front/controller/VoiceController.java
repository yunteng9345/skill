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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lly.front.model.Theme;
import com.lly.front.model.Voice;
import com.lly.front.serviceImp.ThemeServiceImpl;
import com.lly.front.serviceImp.VoiceServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/*
 * 录音前端控制器
 */
@Controller
@RequestMapping("/voice")
public class VoiceController {
	@Autowired
	private VoiceServiceImpl voiceServiceImpl;

	public void setVoiceServiceImpl(VoiceServiceImpl voiceServiceImpl) {
		this.voiceServiceImpl = voiceServiceImpl;
	}
	@Autowired
	private ThemeServiceImpl themeServiceImpl;

	public void setThemeServiceImpl(ThemeServiceImpl themeServiceImpl) {
		this.themeServiceImpl = themeServiceImpl;
	}
	/*
	 * 添加录音
	 */
	@RequestMapping(value = "/addVoice", method = RequestMethod.POST)
	public  void addVoice(@RequestParam String tid,@RequestParam String openId,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(openId);
		Voice voice = new Voice();
		voice.setOpenid(openId);
		voice.setVtext("");
		// 设置时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String publishtime = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		voice.setPublishtime(publishtime);
		voice.setTid(tid);
		//System.out.println(tid);
		//添加录音文件到项目根文件下
		MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;  
	    MultipartFile multipartFile =  req.getFile("file"); 
	    
	    // = "E:\\java_project\\MakeYouListen\\WebContent\\voices";  
	    File file00 = new File(Voice.class.getClassLoader().getResource("../../1.txt").getPath());
	    String realPath1 = file00.getAbsolutePath();
	    String realPath  = realPath1.replace("1.txt", "voices/");
	    
	    //System.out.println(realPath);
	    File dir = new File(realPath);  
        if (!dir.exists()) {  
            dir.mkdir();  
        }  
        UUID uuid =UUID.randomUUID();
        File file  =  new File(realPath,uuid+".mp3"); 
        try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		voice.setVaddr(uuid+".mp3");
		//System.out.println("录音储存成功");
		voice.setVtime("录音时长");
		
		voiceServiceImpl.insertVoice(voice);
		System.out.println("录音保存成功");
		
		//return null;
	}
	
	
	/*
	 * 添加录音文字
	 */
	@RequestMapping(value = "/addVoiceText", method = RequestMethod.GET)
	public  void addVoicetext(@RequestParam String vtext,@RequestParam String tid,@RequestParam String openId,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String vtext1 = new String(vtext.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(openId);
		Voice voice = new Voice();
		voice.setOpenid(openId);
		voice.setVtext(vtext1);
		// 设置时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String publishtime = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		voice.setPublishtime(publishtime);
		voice.setTid(tid);
		voice.setVaddr("");
		voice.setVtime("录音时长");
		//System.out.println(tid);
		voiceServiceImpl.insertVoice(voice);
		System.out.println("录音文字保存成功");
		
		//return null;
	}

	/*
	 * 显示录音
	 */
	@RequestMapping(value = "/allMessage", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	
	public @ResponseBody String allMessage(@RequestParam String tid,HttpServletRequest request, HttpSession session) {
			Voice voice = new Voice();
			voice.setTid(tid);
			
			//根据tid查询所有声音信息
			List<Voice> voiceList = voiceServiceImpl.selectVoiceByTid(voice);
			JSONArray listArray = JSONArray.fromObject(voiceList);
			//创建一个json对象数组
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("allVoice", listArray);
			
			
			//根据tid查询主题信息
			Theme theme = new Theme();
			theme.setTid(Integer.parseInt(tid));
			Theme theme2 = themeServiceImpl.selectThemeByTid(theme);
			JSONObject json = JSONObject.fromObject(theme2);
			map.put("theme", json);
			
			//System.out.println(map.values());
			
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("显示相应主题录音列表成功！");
			return jsonObject.toString();
			
		
	}
	/*
	 * 根据vid查询唯一的一个录音
	 */
	/*
	 * 显示录音
	 */
	@RequestMapping(value = "/selectVoiceByVid", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	
	public @ResponseBody String selectVoiceByVid(@RequestParam String vid) {
			Voice voice = new Voice();
			voice.setVid(vid);
			
			
			Voice voice1= voiceServiceImpl.selectVoiceByVid(voice);
			JSONObject json = JSONObject.fromObject(voice1);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("voice", json);
	
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("根据vid查询唯一的录音成功！");
			return jsonObject.toString();
			
		
	}
}
