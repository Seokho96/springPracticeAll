package bit.com.a.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import bit.com.a.service.PdsService;

// 다운로드 버튼을 누르면 여기로 온다
public class DownloadView extends AbstractView{  //가상 뷰

	@Autowired
	PdsService service;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//System.out.println("DownloadView renderMergedOutputModel");
		
		File file = (File)model.get("downloadFile");  // == getAttribute
		
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		
		// IE(익스플로어)/Chrome
		String userAgent = request.getHeader("user-Agent");
		boolean ie = userAgent.indexOf("MISE") > -1;   // true가 나오면 익스
		
		String filename = null;
		if(ie) {
			filename = URLEncoder.encode(file.getName(), "utf-8");
		}else {
			filename = new String( file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		// 다운로드 창
				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
				response.setHeader("Content-Transfer-Encoding", "binary;");
				response.setHeader("Content-Length", "" + file.length());
				response.setHeader("Pragma", "no-cache;"); 
				response.setHeader("Expires", "-1;");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = null;
		
		fi = new FileInputStream(file);   // 파일의 내용을 읽음
		FileCopyUtils.copy(fi, out);  // 실질적으로 파일을 읽음
		
		// down load count 증가
		
		if(fi != null) {
			fi.close();
		}
	}

	
}
