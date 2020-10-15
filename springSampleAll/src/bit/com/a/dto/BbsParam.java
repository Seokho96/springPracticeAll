package bit.com.a.dto;

import java.io.Serializable;

public class BbsParam implements Serializable {


	// 검색
	 private String s_category;
	 private String keyword;
	 
	//페이징
	 private int pageNumber = 0; //현재 페이지
	 private int recordCountPerPage = 10;  // 표현할 페이지의 글 수 
	 private int start = 1;
	 private int end = 10;

	public BbsParam() {
		
	} 
	 
	public BbsParam(String s_category, String keyword) {
		super();
		this.s_category = s_category;
		this.keyword = keyword;
	}


	public BbsParam(String s_category, String keyword, int pageNumber, int recordCountPerPage, int start, int end) {
		super();
		this.s_category = s_category;
		this.keyword = keyword;
		this.pageNumber = pageNumber;
		this.recordCountPerPage = recordCountPerPage;
		this.start = start;
		this.end = end;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	 
	
	
}
