package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalendarDto;
import bit.com.a.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	CalendarDao dao;
	
	public List<CalendarDto> getCalendarList(CalendarDto cal) {
		List<CalendarDto> list = dao.getCalendarList(cal);
            return list;
	}

	@Override
	public boolean writeCalendar(CalendarDto dto) {
		
		return dao.writeCalendar(dto);
	}

	@Override
	public CalendarDto calDetail(int seq) {
		
		return dao.calDetail(seq);
	}
	
	
	
	

}
