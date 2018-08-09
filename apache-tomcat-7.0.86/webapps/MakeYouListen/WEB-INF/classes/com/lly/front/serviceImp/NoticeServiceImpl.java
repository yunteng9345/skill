package com.lly.front.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lly.front.Dao.CRUDByXmlMapper;
import com.lly.front.model.Notice;
import com.lly.front.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	
	
	@Autowired
	private CRUDByXmlMapper crud;
	
	public void setCrud(CRUDByXmlMapper crud) {
		this.crud = crud;
	}
	@Override
	public List<Notice> showAllNotice() {
		
		return crud.showAllNotice();
	}

}
