package com.lly.front.serviceImp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lly.front.Dao.CRUDByXmlMapper;
import com.lly.front.model.Voice;
import com.lly.front.service.VoiceService;

/*
 * 录音服务实现类
 */
@Service
public class VoiceServiceImpl implements VoiceService {


	@Autowired
	private CRUDByXmlMapper crud;
	
	public void setCrud(CRUDByXmlMapper crud) {
		this.crud = crud;
	}
	@Override
	public Integer insertVoice(Voice voice) {
		
		return crud.insertVoice(voice);
	}
	@Override
	public List<Voice> selectVoiceByTid(Voice voice) {
		return crud.selectVoiceByTid(voice);
		
	}
	@Override
	public Voice selectVoiceByVid(Voice voice) {
		
		return crud.selectVoiceByVid(voice);
	}

}
