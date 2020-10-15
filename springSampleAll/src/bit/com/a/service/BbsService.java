package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {
	
	public List<BbsDto> BbsList(BbsParam search) throws Exception;
	
	public boolean BbsWrite(BbsDto dto) throws Exception;
	
	public BbsDto BbsDetail(int seq) throws Exception;
	
	public void BbsDelete(int seq) throws Exception;
	
	public void BbsUpdate( BbsDto dto ) throws Exception;
	
	int getBbsCount(BbsParam param) throws Exception;

}
