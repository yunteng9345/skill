package com.lly.front.service;

import java.util.List;

import com.lly.front.model.Theme;

/*
 * 主题服务
 */
public interface ThemeService{
	List<Theme> showAllTheme();
	//Theme selectThemeByTid(ThemeService theme);
	Theme selectThemeByTid(Theme theme);
	//对应tid的voice评论条数
	
}
