package bit.com.a.dto;

import java.io.Serializable;

/*
CREATE TABLE CALENDARPLUG(
		   SEQ NUMBER(8) PRIMARY KEY,
		   ID VARCHAR2(50) NOT NULL,
		   SLEVEL NUMBER(8),
		   TITLE VARCHAR2(200) NOT NULL,
		   CONTENT VARCHAR2(4000) NOT NULL,
		   STARTDATE VARCHAR2(19) NOT NULL,
		   ENDDATE VARCHAR2(19),
		   WDATE DATE NOT NULL
		);

		CREATE SEQUENCE SEQ_CALPLUG
		START WITH 1
		INCREMENT BY 1;

		ALTER TABLE CALENDARPLUG
		ADD CONSTRAINT FK_CALPLUG_ID FOREIGN KEY(ID)
		REFERENCES MEMBER(ID);
		
		INSERT INTO CALENDARPLUG(SEQ, ID, SLEVEL, TITLE, CONTENT, STARTDATE, ENDDATE, WDATE)
VALUES(SEQ_CALPLUG.NEXTVAL, 'aaa',1, '비즈니스 약속', '계약서 작성건', '2020-09-25T12:30:00','', SYSDATE)

INSERT INTO CALENDARPLUG(SEQ, ID, SLEVEL, TITLE, CONTENT, STARTDATE, ENDDATE, WDATE)
VALUES(SEQ_CALPLUG.NEXTVAL, 'aaa',1, '취업', '중요', '2020-09-29T09:30:00','', SYSDATE)

INSERT INTO CALENDARPLUG(SEQ, ID, SLEVEL, TITLE, CONTENT, STARTDATE, ENDDATE, WDATE)
VALUES(SEQ_CALPLUG.NEXTVAL, 'aaa',1, '생일파티', '파티', '2020-09-19T18:40:00','', SYSDATE)
		*/

public class CalendarPlugDto implements Serializable {
	
	private int seq;
	private String id;
	private String slevel; // 중요도: 1, 2, 3
	private String title;
	private String content;
	private String startdate;      // == rdate
	private String enddate;
	private String wdate;         // 작성일
	
	
    public CalendarPlugDto() {
		
	}

	public CalendarPlugDto(int seq, String id, String slevel, String title, String content, String startdate,
			String enddate, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.slevel = slevel;
		this.title = title;
		this.content = content;
		this.startdate = startdate;
		this.enddate = enddate;
		this.wdate = wdate;
	}
	
	

	public CalendarPlugDto(String id, String slevel, String title, String content, String startdate, String enddate) {
		super();
		this.id = id;
		this.slevel = slevel;
		this.title = title;
		this.content = content;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSlevel() {
		return slevel;
	}

	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "CalendarPlugDto [seq=" + seq + ", id=" + id + ", slevel=" + slevel + ", title=" + title + ", content="
				+ content + ", startdate=" + startdate + ", enddate=" + enddate + ", wdate=" + wdate + "]";
	}
    
	
	
	
}
