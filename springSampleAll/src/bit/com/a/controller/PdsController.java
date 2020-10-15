package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;
import bit.com.a.service.PdsService;
import bit.com.a.util.PdsUtil;

@Controller
public class PdsController {
	
    @Autowired
    PdsService service;
    
    @RequestMapping(value = "pdslist.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String getPdsList( Model model, PdsParam param) {
    	model.addAttribute("doc_title", "자료실목록");
    	System.out.println(param.getKeyword());
    	System.out.println(param.getS_category());
    	List<PdsDto> pdslist = service.getPdsList( param );
    	model.addAttribute("pdslist", pdslist);
    	
    	return "pdslist.tiles";
    }
    
    @RequestMapping(value = "pdswrite.do" , method = RequestMethod.GET)
    public String uploadPdsView( Model model ) {
    	model.addAttribute("doc_title", "작성");
    	
		return "pdswrite.tiles";
	}
    
   
    @RequestMapping(value = "pdsupload.do" , method = RequestMethod.POST)
    public String pdsupload( PdsDto dto,
    	        @RequestParam (value = "fileload", required = false)MultipartFile fileload,
    	        HttpServletRequest req) {
    	
    	//filename 취득
        String filename = fileload.getOriginalFilename();
        dto.setOldfilename(filename);
        
        // upload 경로
        // server
        String fupload = req.getServletContext().getRealPath("/upload");
        
        // 폴더
    	//String fupload = "d:\\tmp";
        
        System.out.println("fupload: " + fupload);
        
        // file명을 취득
        String f = dto.getOldfilename();
        String newfilename = PdsUtil.getNewFileName( f );
        
        dto.setFilename(newfilename);
        
        File file = new File(fupload + "/" + newfilename);
             
        try {
        	 // 파일이 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			//db에 저장
			service.uploadPds(dto);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
        return "redirect:/pdslist.do";
	}
    
    @RequestMapping(value = "fileDownload.do" , method = RequestMethod.POST)
    public String fileDownload(String filename, int seq, HttpServletRequest req, Model model) {
    	
    	// 경로
    	// server
    	 String fupload = req.getServletContext().getRealPath("/upload");
    	
    	// 폴더
    	//String fupload = "d:\\tmp";
    	 
    	File downloadFile =  new File(fupload + "/" + filename);
    	
    	model.addAttribute("downloadFile", downloadFile);
    	model.addAttribute("seq", seq);
    	return "downloadView";
    }
    
    @RequestMapping(value = "pdsdetail.do", method = RequestMethod.GET)
    public String pdsdetail( int seq, Model model) {
		model.addAttribute("doc_title", "자료실 상세보기");
		
		PdsDto pdsDetail = service.detailPds(seq);
		
		model.addAttribute("pdsDetail", pdsDetail);
		
		return "pdsdetail.tiles";
	}
    
    @RequestMapping(value = "pdsupdate.do", method = RequestMethod.GET)
    public String pdsupdate( int seq, Model model) {
		model.addAttribute("doc_title", "자료 수정하기");
		
		PdsDto pdsDetail = service.detailPds(seq);
		
		model.addAttribute("pds", pdsDetail);
		
		return "pdsupdate.tiles";
	}
    
    
    
    @RequestMapping(value = "pdsupdateAf.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String pdsupdateAf( PdsDto dto, 
                               String namefile, //기존 파일명
                               HttpServletRequest req,
                               @RequestParam(value = "fileload", required = false)MultipartFile fileload) {
		
    dto.setOldfilename(fileload.getOriginalFilename());
   // System.out.println(dto.getOldfilename());
    // 파일 경로
    String fupload = req.getServletContext().getRealPath("/upload");  // 서버
    
    // 수정할 파일이 있음
    if(dto.getOldfilename() != null && !dto.getOldfilename().equals("")) {
    	System.out.println("수정파일");
    	String f = dto.getOldfilename();
    	String newfilename = PdsUtil.getNewFileName(f);
    	
    	dto.setFilename(newfilename);
    	
    	File file =  new File(fupload + "/" + newfilename);
    	
    	
    	try {
    		//실제 업로드
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			System.out.println(dto.getOldfilename());
			//db갱신
			service.updatePds(dto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    else {    // 파일이 수정하지 않고 그대로 일 때
    	
    	// 기존의 파일명으로 설정
    	dto.setFilename(namefile);
    	
    	//DB
    	service.updatePds(dto);
    	
    }
		
		return "redirect:/pdslist.do";
	}
    
    @RequestMapping(value = "pdsdelete.do", method = RequestMethod.POST )
      public String pdsdelete( int seq ) {
    	
    	   service.deletePds(seq);
    	
    	return "redirect:/pdslist.do";
    }

}
