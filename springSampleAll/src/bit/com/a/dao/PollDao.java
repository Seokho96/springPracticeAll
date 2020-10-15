package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.PolSubDto;
import bit.com.a.dto.PollDto;
import bit.com.a.dto.Voter;

public interface PollDao {
	
	List<PollDto> getPollAllList();
	
	int isVote(Voter voter);
	
	void makePoll(PollDto poll);
	
	void makePollSub( PolSubDto polsub);
	
	PollDto getPoll( PollDto poll );
	
	List<PolSubDto> getPollSubList( PollDto poll);
	
	void pollingVoter( Voter voter) ;
	
	void pollingPoll( Voter voter );
	
	void pollingSub( Voter voter );

}
