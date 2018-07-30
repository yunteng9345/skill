package com.lly.front.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lly.front.Dao.CRUDByXmlMapper;
import com.lly.front.model.Theme;
import com.lly.front.service.ThemeService;

/*
 * 主题服务实现类
 */
@Service
public class ThemeServiceImpl implements ThemeService{
	@Autowired
	private CRUDByXmlMapper crud;
	
	public void setCrud(CRUDByXmlMapper crud) {
		this.crud = crud;
	}
	
	@Override
	public List<Theme> showAllTheme() {
		
		return crud.showAllTheme();
	}

	@Override
	public Theme selectThemeByTid(Theme theme) {
		
		return crud.selectThemeByTid(theme);
	}

}
