package com.lly.front.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lly.front.model.DaTi;
import com.lly.front.model.User;
import com.lly.front.service.UserService;
import com.lly.front.Dao.CRUDByXmlMapper;

/*
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CRUDByXmlMapper crud;
	
	public void setCrud(CRUDByXmlMapper crud) {
		this.crud = crud;
	}
	
	@Override
	public Integer insertUserInfo(User user) {
		return crud.insertUserInfo(user);
	}

	@Override
	public Integer alterUserInfo(User user) {
		return crud.alterUserInfo(user);
		
	}

	@Override
	public User selectUserByOpenid(User user) {
		return crud.selectUserByOpenid(user);
	}

	@Override
	public Integer inserDatiUserInfo(DaTi dati) {
	
		return crud.inserDatiUserInfo(dati);
	}

	@Override
	public List<DaTi> showAllDatiInfo() {
		
		return crud.showAllDatiInfo();
	}

}
