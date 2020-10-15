package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.dto.Youtube;
import bit.com.a.dto.YoutubeSave;
import bit.com.a.service.YoutubeService;
import bit.com.a.util.YoutubeParser;

@Controller
public class YoutubeController {
	
	@Autowired
    private YoutubeParser youtubeParser;
	
	@Autowired
	YoutubeService service;

	@RequestMapping(value = "youtube.do" , method = { RequestMethod.GET, RequestMethod.POST} )
	public String youtube(String s_keyword, Model model) {
		model.addAttribute("doc_title", "유튜브");
		
		//검색 ***************
		//youtubeParser.getTitles("백종원");
		
		if(s_keyword != null && !s_keyword.equals("")) {
			List<Youtube> getTitles = youtubeParser.getTitles(s_keyword);
			
			model.addAttribute("yulist", getTitles);
			model.addAttribute("s_keyword", s_keyword);
				
		}
		
		return "youtube.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "youtubesave.do" , method = { RequestMethod.GET, RequestMethod.POST} )
	public String youtubeSave(YoutubeSave yousave, Model model) {
		
		System.out.println(yousave.getId() +"  "+ yousave.getTitle() +  " "  + yousave.getUrl() );
		
		String a = service.youtubeSave(yousave);
			
		return a;
	}
	
	@RequestMapping(value = "youtubesavelist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String youtubeSaveList( Model model, YoutubeSave yousave, HttpServletRequest req ) {
		model.addAttribute("doc_title", "저장목록");
		
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
        yousave.setId(id);		
		List<Youtube> list = service.getYouteSaveList(yousave);
		
		model.addAttribute("savelist", list);
		
		return "youtubesavelist.tiles";
	}
	
	@RequestMapping(value = "youdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String youDeleteList( YoutubeSave yousave ) {
				
		service.deletelist(yousave);
		
		return "redirect:/youtubesavelist.do";
	}
	
}
