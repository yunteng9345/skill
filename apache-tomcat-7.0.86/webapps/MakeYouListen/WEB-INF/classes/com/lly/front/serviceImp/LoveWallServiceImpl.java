package com.lly.front.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lly.front.Dao.CRUDByXmlMapper;
import com.lly.front.model.LoveWall;
import com.lly.front.service.LoveWallService;

@Service
public class LoveWallServiceImpl implements LoveWallService {

	@Autowired
	private CRUDByXmlMapper crud;
	
	public void setCrud(CRUDByXmlMapper crud) {
		this.crud = crud;
	}
	
	
	@Override
	public Integer insertintoLoveWall(LoveWall loveWall) {
		
		return crud.insertintoLoveWall(loveWall);
	}

	@Override
	public List<LoveWall> showAllLoveWall() {
		
		return crud.showAllLoveWall();
	}


	@Override
	public LoveWall selectLoveWallByLno(LoveWall loveWall) {
		
		return crud.selectLoveWallByLno(loveWall);
	}

}
