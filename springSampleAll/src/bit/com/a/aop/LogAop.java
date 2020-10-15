package bit.com.a.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.a.dto.MemberDto;




@Aspect
public class LogAop {
	
	/*
	 * @Autowired 
	 * BbsService bbsService;    //DB 체크 가능
	 */
	
	@Around("within(bit.com.a.controller.*) or within(bit.com.a.dao.impl.*) or within(bit.com.a.service.impl.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		   String signatureStr = joinpoint.getSignature().toShortString();
		   
		  // System.out.println(signatureStr +" 시작 ");  //실행 전
		   
		   // signatureStr 가 뭐뭐면 세션체크를 하지마라 라는 조건문을 둘 수 있음
		   
		   //session check
		   HttpServletRequest request
		   = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		   
		   if(request != null) {  // session이 있음
			   HttpSession session = request.getSession();
			   MemberDto login = (MemberDto)session.getAttribute("login");
			   if(login == null) {
				   return "redirect:/sessionOut.do";
			   }
			   
		   }
		   try {
			   System.out.println("loggerAOP: " + signatureStr + "메소드가 실헹되었습니다");
			   
			   Object obj = joinpoint.proceed();       //실행 시
			   
			   return obj;
		} finally {
			//System.out.println("실행 후 "+ System.currentTimeMillis());
			//System.out.println(signatureStr +" 종료 ");  //실행 후
				
		}
	}

}
