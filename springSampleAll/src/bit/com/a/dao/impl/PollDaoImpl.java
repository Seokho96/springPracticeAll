package bit.com.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.PollDao;
import bit.com.a.dto.PolSubDto;
import bit.com.a.dto.PollDto;
import bit.com.a.dto.Voter;

@Repository
public class PollDaoImpl implements PollDao {

	@Autowired
	SqlSessionTemplate sql;
	
	String ns = "Poll.";

	@Override
	public List<PollDto> getPollAllList() {
		
		return sql.selectList(ns +"getPollAllList");
	}

	@Override
	public int isVote(Voter voter) {
		
		return sql.selectOne(ns + "isVote", voter);
	}

	@Override
	public void makePoll(PollDto poll) {
		
		 sql.insert(ns + "makePoll", poll);
		
	}

	@Override
	public void makePollSub(PolSubDto polsub) {


		sql.insert(ns + "makePollSub", polsub);
		
	}

	@Override
	public PollDto getPoll(PollDto poll) {
		
		return sql.selectOne(ns + "getPoll", poll);
	}

	@Override
	public List<PolSubDto> getPollSubList(PollDto poll) {
		
		return sql.selectList(ns +"getPollSubList", poll);
	}

	@Override
	public void pollingVoter(Voter voter) {

       sql.insert(ns + "pollingVoter", voter);		
	}

	@Override
	public void pollingPoll(Voter voter) {
		
		sql.update(ns + "pollingPoll", voter);		
	}

	@Override
	public void pollingSub(Voter voter) {

		sql.update(ns + "pollingSub", voter);	
	}
	
	
	
}
