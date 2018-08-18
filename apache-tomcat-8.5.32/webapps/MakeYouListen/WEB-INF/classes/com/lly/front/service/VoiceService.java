package com.lly.front.service;

import java.util.List;

import com.lly.front.model.Voice;

/*
 * 录音服务
 */
public interface VoiceService {
	//添加录音
	Integer insertVoice(Voice voice);
	//显示录音,根据主题的对应值
	List<Voice> selectVoiceByTid(Voice voice);
	//查询录音通过vid
	Voice selectVoiceByVid(Voice voice);
}
