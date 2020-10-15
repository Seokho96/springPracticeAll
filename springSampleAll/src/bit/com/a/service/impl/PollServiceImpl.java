package bit.com.a.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.PollDao;
import bit.com.a.dto.PolSubDto;
import bit.com.a.dto.PollBean;
import bit.com.a.dto.PollDto;
import bit.com.a.dto.Voter;
import bit.com.a.service.PollService;

@Service
public class PollServiceImpl implements PollService {

	@Autowired
	PollDao dao;

	@Override
	public List<PollDto> getPollAllList( String id ) {
		
		// 모든 투표목록을 갖고온다.
		List<PollDto> list = dao.getPollAllList();
		
		for (int i = 0; i < list.size(); i++) {
			PollDto dto = list.get(i);
			System.out.print(dto.toString());
		}
		
		// 편집을 해서 투표가 가능한지 설정해서 넘겨줄 리스트
		List<PollDto> plist = new ArrayList<PollDto>();
		
		for (PollDto poll : list) {
			int pollid = poll.getPollid();  //투표번호
            
			// 투표를 했으면 1, 안했으면 0
            int count = dao.isVote(new Voter(pollid, -1, id)); 
            if(count == 1) {  //투표 했음
            	poll.setVote(true);
            	
            }else {   // 안했음
            	poll.setVote(false);
            }
            plist.add(poll);
		}
		
		return plist;
	}

	@Override
	public void makePoll(PollBean pbean) {
		
		// 투표 주제
		PollDto poll = new PollDto(pbean.getId(), 
				                   pbean.getQuestion(), 
				                   pbean.getSdate(), 
				                   pbean.getEdate(), 
				                   pbean.getItemcount(), 0);
		dao.makePoll(poll);
		
		// 투표 보기들
		String answer[] = pbean.getPollnum();
		
		for (int i = 0; i < pbean.getItemcount(); i++) {
			PolSubDto polsub= new PolSubDto();
			polsub.setAnswer(answer[i]);
			
			dao.makePollSub(polsub);
		}
		
	}

	@Override
	public PollDto getPoll(PollDto poll) {
		
		return dao.getPoll(poll);
	}

	@Override
	public List<PolSubDto> getPollSubList(PollDto poll) {
		
		return dao.getPollSubList(poll);
	}

	@Override
	public void polling(Voter voter) {
		
		dao.pollingVoter(voter);
		dao.pollingPoll(voter);
		dao.pollingSub(voter);
	
	}
	
	
	
	
}










