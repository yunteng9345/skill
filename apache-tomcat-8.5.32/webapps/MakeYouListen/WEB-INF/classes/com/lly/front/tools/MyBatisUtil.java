package com.lly.front.tools;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月23日 上午10:56:49
* 类说明
*/
public class MyBatisUtil {
	/*
	 * 获取SqlSessionFactoty
	 * @return SqlSessionFactoty
	 */
	public static  SqlSessionFactory getSqlSessionFactoty() {
		String resource = "conf.xml";
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}
	/*
	 * 获取SqlSession
	 * @return SqlSession
	 */
	public SqlSession getSqlSession() {
		return getSqlSessionFactoty().openSession();
	}
	/*
	 * 获取SqlSession
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) {
		return getSqlSessionFactoty().openSession(isAutoCommit);
	}

}
