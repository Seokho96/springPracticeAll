package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.YoutubeDao;
import bit.com.a.dto.Youtube;
import bit.com.a.dto.YoutubeSave;


@Repository
public class YoutubeDaoImpl implements YoutubeDao {

	@Autowired
	SqlSessionTemplate sql;
	
	String ns = "Youtube.";
	
	@Override
	public String youtubeSave(YoutubeSave yousave) {
			
		try {
			sql.insert(ns + "youtubesave", yousave);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	@Override
	public int checklist(YoutubeSave yousave) {
		
		return sql.selectOne(ns +"checklist", yousave);
	}

	@Override
	public List<Youtube> getYouteSaveList(YoutubeSave yousave) {
		
		return sql.selectList(ns +"youtubesavelist", yousave);
	}

	@Override
	public void deletelist(YoutubeSave yousave) {
		
		sql.delete(ns + "deletelist", yousave);
		
	}

	
	

}
