package bit.com.a.service;

import java.util.List;


import bit.com.a.dto.Youtube;
import bit.com.a.dto.YoutubeSave;


public interface YoutubeService {
	
	 String youtubeSave(YoutubeSave yousave); 
	 
	 List<Youtube> getYouteSaveList(YoutubeSave yousave);
	 
	 void deletelist(YoutubeSave yousave);

}
