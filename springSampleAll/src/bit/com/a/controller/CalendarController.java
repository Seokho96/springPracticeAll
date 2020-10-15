package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.CalendarService;
import bit.com.a.util.CalendarUtil;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService service;
	
	@RequestMapping(value = "calendarlist.do", method = RequestMethod.GET)
	public String getCalendarList( Model model, HttpSession session, CalendarParam cal ) {
		model.addAttribute("doc_title", "일정");
		
        cal.calculate();
		
		// 로그인 정보
		String id = ((MemberDto)session.getAttribute("login")).getId();
		// 날짜 취득
		String yyyymm = CalendarUtil.yyyymm(cal.getYear(), cal.getMonth());
		
		// dto set
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> list = service.getCalendarList(fcal);
		
		model.addAttribute("flist", list);
		model.addAttribute("cal", cal);
		
		return "calendar.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "writeCalendarAf.do", method = RequestMethod.POST)
	public String writeCalendarAf( HttpSession session, CalendarDto cal ) throws Exception{
		String a ="";
		boolean isS = service.writeCalendar(cal);
		
		if(isS) {
			 a = "yes";
		}else {
			a = "no";
		}
		    return a;
	}
	
	@RequestMapping(value = "writeCalendar.do", method = RequestMethod.GET)
	public String writeCalendar( Model model, CalendarParam calp ) {
		model.addAttribute("doc_title", "일정쓰기");
	    calp.calculate();
	    
	    model.addAttribute("calp", calp);
	    
		  return "writeCalendar.tiles";
	}
	
	@RequestMapping(value = "caldetail.do", method = RequestMethod.GET)
	public String caldetail( Model model, int seq) {
		model.addAttribute("doc_title", "상세 일정");
	    
		CalendarDto dto = service.calDetail(seq);
		model.addAttribute("caldetail", dto);
	
	    
		  return "detailCalendar.tiles";
	}
	
	
}
