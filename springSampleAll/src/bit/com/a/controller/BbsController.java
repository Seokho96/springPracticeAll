package bit.com.a.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
   
	@Autowired
	BbsService bbsservice;

	/*
	@RequestMapping(value = "bbslist.com")
	public String bbslist( Model model, BbsParam search ) throws Exception {
		 System.out.println("BbsController bbslist()"); 
		 
		 model.addAttribute("doc_title", "글목록");
		 List<BbsDto> list = bbsservice.BbsList(search);
		 model.addAttribute("bbslist", list);
		 
		 return "bbslist.tiles";
	}
	*/
	
	@RequestMapping(value = "bbslist.do")
	public String bbslist( Model model, BbsParam param ) throws Exception {
		 System.out.println("BbsController bbslist()"); 
		 model.addAttribute("doc_title", "글목록");
		 // paging 처리
		 int sn = param.getPageNumber();  // 현재 페이지
		 int start = sn * param.getRecordCountPerPage() + 1;  // 1  11  21 ... 
		 int end = (sn + 1) * param.getRecordCountPerPage();  // 10  20  30 
		 
		 param.setStart(start);
		 param.setEnd(end);
		 
		
		 List<BbsDto> list = bbsservice.BbsList(param);
		 model.addAttribute("bbslist", list);
		 
		 //글의 총수 
		 int totalRecordCount = bbsservice.getBbsCount(param);
		 model.addAttribute("pageNumber", sn);
		 model.addAttribute("pageCountPerScreen", 10);
		 model.addAttribute("recordCountPerPage", param.getRecordCountPerPage());
		 model.addAttribute("totalRecordCount", totalRecordCount);
		 model.addAttribute("keyword", param.getKeyword());
		 model.addAttribute("s_category", param.getS_category());
		
		 
		 return "bbslist.tiles";
	}

	@RequestMapping(value = "bbsdetail.do")
	public String bbsdetail( Model model, int seq ) throws Exception {
		 System.out.println("BbsController bbslist()"); 
		 
		 model.addAttribute("doc_title", "글 상세보기");
		 BbsDto dto = bbsservice.BbsDetail(seq);
		 model.addAttribute("bbsdetail", dto);
		 
		 return "bbsdetail.tiles";
	}
	
	@RequestMapping(value = "bbswrite.do")
	public String bbswrite( Model model ){
		 System.out.println("BbsController bbswrite()"); 
		 
		 model.addAttribute("doc_title", "글쓰기");
		 
		 return "bbswrite.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf( BbsDto dto) throws Exception {
		 System.out.println("BbsController bbswriteAf()"); 
		 String msg = "";
		 boolean isS = bbsservice.BbsWrite(dto);
		    
		  if(isS) {
			  msg = "yes";
		  }else {
			  msg="no";
		  }
		 return msg;
	}
	
	@RequestMapping(value = "bbsupdate.do")
	public String bbsupdate( Model model, int seq ) throws Exception{
		 System.out.println("BbsController bbsupdate()"); 
		 
		 BbsDto bbsupdate = bbsservice.BbsDetail(seq);
		 
		 model.addAttribute("doc_title", "글수정");
		 model.addAttribute("bbsupdate", bbsupdate); 
		 
		 return "bbsupdate.tiles";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = RequestMethod.POST)
	public String bbsdelete(int seq) throws Exception{
		 System.out.println("BbsController bbswrite()"); 
		 
		 bbsservice.BbsDelete(seq);
				 
		 return "bbslist.tiles";
	}
}


















