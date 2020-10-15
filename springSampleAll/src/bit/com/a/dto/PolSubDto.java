package bit.com.a.dto;

import java.io.Serializable;

/*
DROP TABLE POLLSUB
CASCADE CONSTRAINTS;

DROP SEQUENCE POLLSUB_SEQ;

CREATE TABLE POLLSUB(
     POLLSUBID NUMBER NOT NULL,
     POLLID NUMBER NOT NULL,
     ANSWER VARCHAR2(1000) NOT NULL,
     ACCOUNT NUMBER NOT NULL,
     CONSTRAINT POLLSUB_PK PRIMARY KEY(POLLSUBID)
);

CREATE SEQUENCE POLLSUB_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE POLLSUB ADD CONSTRAINT POLLSUB_FK
FOREIGN KEY(POLLID)
REFERENCES POLL(POLLID);
*/



// 투표 보기[ex) 후보자 명단]
public class PolSubDto implements Serializable {
	
	private int pollsubid;   // seq
	private int pollid;      // 질문번호 <- 외래키 (투표 질의 테이블)
	private String answer;   // 보기명  <- 사과, 배, 바나나
	
	// 통계
	private int account;      // 이 보기를 선택한 사람수
	
	
    public PolSubDto() {
		
	}

    
    
	public PolSubDto(int pollsubid, int pollid, String answer, int account) {
		super();
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.account = account;
	}



	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}



	@Override
	public String toString() {
		return "PolSubDto [pollsubid=" + pollsubid + ", pollid=" + pollid + ", answer=" + answer + ", account=" + account
				+ "]";
	}
    
    

	
}
