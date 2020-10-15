package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.Youtube;
import bit.com.a.dto.YoutubeSave;

public interface YoutubeDao {

	String youtubeSave( YoutubeSave yousave );
	
	int checklist( YoutubeSave yousave );
	
	List<Youtube> getYouteSaveList( YoutubeSave yousave );
	
	void deletelist( YoutubeSave yousave );
}
