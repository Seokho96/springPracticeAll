package bit.com.a.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
//import org.springframework.web.bind.annotation.RestController;
//@RestController 붙이면 컨트롤러 모든 것이 ajax
@Controller

public class MemberController {
	
	@Autowired
	MemberService memservice;
	
	@RequestMapping(value = "login.do")
	public String login() {
		System.out.println("MemberController login()");
		
		return "login.tiles";
	}
	
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf( MemberDto dto, HttpServletRequest req ) throws Exception {
		System.out.println("MemberController loginAf()");
		 String msg = ""; 
		MemberDto mem = memservice.loginMember(dto); 
		if(mem != null) {
			req.getSession().setAttribute("login", mem);
			 //req.getSession().setMaxInactiveInterval();
			msg = "yes";
		}else {
			msg = "no";
		}
		return "redirect:/bbslist.do";
	}
	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest req) {
		System.out.println("MemberController logout()");
		   req.getSession().removeAttribute("login");
		  
		return "redirect:/login.do";
	}
	
	
	@RequestMapping(value = "regi.do")
	public String regi() {
		System.out.println("MemberController regi()");
		
		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "regiAf.do")
	public String regiAf(MemberDto dto) throws Exception {
		System.out.println("MemberController regiAf()");
		 String msg="";
		memservice.addMember(dto);
		msg = "yes";
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "getId.do")
	public String getId( MemberDto mem ) {
		System.out.println("MemberController regi()");
		String msg ="";
		int count = memservice.getId(mem);
		if(count > 0) {
			
			msg = "yes";
		}else {
			msg = "no";
		}
		
		return msg;
	}
	
	@RequestMapping(value = "sessionOut.do", method = RequestMethod.GET)
      public String sessionOut() {
		return "sessionOut.tiles";
	}
}
