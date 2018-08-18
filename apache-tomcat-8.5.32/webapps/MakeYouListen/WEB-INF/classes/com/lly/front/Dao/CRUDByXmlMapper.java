package com.lly.front.Dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lly.front.model.DaTi;
import com.lly.front.model.LoveComment;
import com.lly.front.model.LoveWall;
import com.lly.front.model.Notice;
import com.lly.front.model.Theme;
import com.lly.front.model.User;
import com.lly.front.model.Voice;
import com.lly.front.tools.MyBatisUtil;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2018年3月25日 下午4:18:11 类说明
 */
@Repository
public class CRUDByXmlMapper {

	/*
	 * 微信用户的操作
	 */

	// 插入微信用户基本数据信息
	public Integer insertUserInfo(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.userMapper.insertUserInfo";
		return sqlSession.insert(statement, user);
	}

	// 修改用户数据
	public Integer alterUserInfo(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.userMapper.alterUserInfo";
		return sqlSession.update(statement, user);
	}

	// 查询是否是第一次登陆
	public User selectUserByOpenid(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.userMapper.selectUserByOpenid";
		return (User) sqlSession.selectOne(statement, user);

	}
	
	
	
	
	
	
	
	/*
	 * 录音的操作
	 */
	
	
	

	// 添加录音
	public Integer insertVoice(Voice voice) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.voiceMapper.insertVoice";
		return sqlSession.insert(statement, voice);
	}

	// 显示录音,根据主题的对应值
	@SuppressWarnings("unchecked")
	public List<Voice> showVoice(Voice voice) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.voiceMapper.showVoice";
		return sqlSession.selectList(statement, voice);
	}
	//根据tid查询所有录音
	@SuppressWarnings("unchecked")
	public List<Voice> selectVoiceByTid(Voice voice) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.voiceMapper.selectVoiceByTid";
		return sqlSession.selectList(statement, voice);
	}
	//根据vid查询录音
	public Voice selectVoiceByVid(Voice voice) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.voiceMapper.selectVoiceByVid";
		return (Voice) sqlSession.selectOne(statement, voice);
	}
	
	

	
	/*
	 * 主题的操作
	 */
	
	
	
	
	// 显示所有主题
	@SuppressWarnings("unchecked")
	public List<Theme> showAllTheme() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.themeMapper.showAllTheme";
		return sqlSession.selectList(statement);
	}
	//查询对应的tid
	public Theme selectThemeByTid(Theme theme) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.themeMapper.selectThemeByTid";
		return (Theme) sqlSession.selectOne(statement,theme);
	}
	
	
	/*
	 * 显示通知
	 */
	@SuppressWarnings("unchecked")
	public List<Notice> showAllNotice(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.noticeMapper.showAllNotice";
		return sqlSession.selectList(statement);
		
	}
	
	
	/*
	 * 
	 * 表白墙
	 */
	
	//添加表白信息
	public Integer insertintoLoveWall(LoveWall loveWall) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.lovewallMapper.insertintoLoveWall";
		return sqlSession.insert(statement, loveWall);
	}
	
	
	//显示所有表白信息
	@SuppressWarnings("unchecked")
	public List<LoveWall> showAllLoveWall(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.lovewallMapper.showAllLoveWall";
		return sqlSession.selectList(statement);
		
	}
	/*
	 * 
	 *表白墙回复
	 */

	public Integer insertLoveComment(LoveComment loveComment) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.lovecommentMapper.insertLoveComment";
		return sqlSession.insert(statement, loveComment);
		//return null;
	}

	/*
	 * 查询所有评论根据lno
	 */
	@SuppressWarnings("unchecked")
	public List<LoveComment> selectLoveCommentByLno(LoveComment loveComment) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.lovecommentMapper.selectLoveCommentByLno";
		//System.out.println(loveComment.getLno());
		return sqlSession.selectList(statement,loveComment);
	}
	/*
	 * 根据lno查询一条表白的主题
	 * 
	 */
	public LoveWall selectLoveWallByLno(LoveWall loveWall) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.lovewallMapper.selectLoveWallByLno";
		return (LoveWall) sqlSession.selectOne(statement, loveWall);
		
	}
	
	
	
	
	/*
	 * 答题系统
	 */
	public Integer inserDatiUserInfo(DaTi dati) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.datiMapper.insertUserInfo";
		return sqlSession.insert(statement, dati);
	}
	
	@SuppressWarnings("unchecked")
	public List<DaTi> showAllDatiInfo() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "com.lly.front.mapping.datiMapper.selectall";
		//System.out.println(loveComment.getLno());
		return sqlSession.selectList(statement);
		
	}
}
