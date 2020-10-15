package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsDao {
	
	 List<BbsDto> BbsList(BbsParam param) throws Exception;
	
	 boolean BbsWrite(BbsDto dto) throws Exception;
	
	 BbsDto BbsDetail(int seq) throws Exception;

	 void BbsDelete(int seq) throws Exception;
	
	 void BbsUpdate(BbsDto dto) throws Exception;
	 
	 int getBbsCount(BbsParam param) throws Exception;
	 
	 

}
