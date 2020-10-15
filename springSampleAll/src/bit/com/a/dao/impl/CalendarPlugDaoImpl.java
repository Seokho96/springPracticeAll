package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CalendarPlugDao;
import bit.com.a.dto.CalendarPlugDto;


@Repository
public class CalendarPlugDaoImpl implements CalendarPlugDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String ns = "CalendarPlug.";

	@Override
	public List<CalendarPlugDto> getCalendarPlugList(CalendarPlugDto dto) {
		
		System.out.println(dto.getId());
		
		return sqlSession.selectList( ns + "getCalendarPlugList", dto);
	}
	
	

}
