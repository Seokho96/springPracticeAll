package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalendarDto;


@Repository
public class CalendarDaoImpl implements CalendarDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String ns = "Calendar.";
	
	@Override
	public List<CalendarDto> getCalendarList(CalendarDto cal){
            return sqlSession.selectList(ns +"getCalendar", cal);
	}

	@Override
	public boolean writeCalendar(CalendarDto dto) {
				
		try {			
			sqlSession.insert(ns + "writeCalendar", dto);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
		}finally {
			
	     	}		
		return true;
	}

	@Override
	public CalendarDto calDetail(int seq) {
		
		return sqlSession.selectOne(ns+"detailCalendar", seq);
	}
	
	
	}
