package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.YoutubeDao;
import bit.com.a.dto.Youtube;
import bit.com.a.dto.YoutubeSave;
import bit.com.a.service.YoutubeService;

@Service
public class YoutubeServiceImpl implements YoutubeService {

	@Autowired
	YoutubeDao dao;
	
	@Override
	public String youtubeSave(YoutubeSave yousave) {
		
	int count =	dao.checklist(yousave);
	
	if(count > 0) {
		
		return "alreadyadded";
		
	}else {
		
	return dao.youtubeSave(yousave);
	}
		 
	}

	@Override
	public List<Youtube> getYouteSaveList(YoutubeSave yousave) {
		
		return dao.getYouteSaveList(yousave);
	}

	@Override
	public void deletelist(YoutubeSave yousave) {
		dao.deletelist(yousave);
		
	}

	

}
