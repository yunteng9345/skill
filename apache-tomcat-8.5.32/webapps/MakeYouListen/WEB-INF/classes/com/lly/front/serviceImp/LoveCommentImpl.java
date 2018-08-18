package com.lly.front.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lly.front.Dao.CRUDByXmlMapper;
import com.lly.front.model.LoveComment;
import com.lly.front.service.LoveCommentService;
@Service
public class LoveCommentImpl implements LoveCommentService {

	@Autowired
	private CRUDByXmlMapper crud;
	
	public void setCrud(CRUDByXmlMapper crud) {
		this.crud = crud;
	}
	
	@Override
	public Integer insertLoveComment(LoveComment loveComment) {
		
		return crud.insertLoveComment(loveComment);
	}

	@Override
	public List<LoveComment> selectLoveCommentByLno(LoveComment loveComment) {
		//System.out.println(loveComment.getLno());
		return crud.selectLoveCommentByLno(loveComment);
	}

}
