package bit.com.a.dto;

public class PdsParam {
	
	// 검색
    private String s_category;
	private String keyword;
	
    public PdsParam() {
    }
   
	
	public PdsParam(String s_category, String keyword) {
	super();
	this.s_category = s_category;
	this.keyword = keyword;
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
		 
	
	

}
