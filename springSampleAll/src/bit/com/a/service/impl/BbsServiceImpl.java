package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao bbsDao;
	
	@Override
	public List<BbsDto> BbsList(BbsParam search) throws Exception{
		List<BbsDto> list  = bbsDao.BbsList(search);
		return list;
	}
	@Override
	public int getBbsCount(BbsParam param) throws Exception{
		return bbsDao.getBbsCount(param);
	}
	
	public boolean BbsWrite(BbsDto dto) throws Exception{
		
		boolean isS = bbsDao.BbsWrite(dto);
		return isS;
		
	}
	
	public BbsDto BbsDetail( int seq) throws Exception{
		
		BbsDto dto = bbsDao.BbsDetail(seq);
		
		return dto;
	}
	public void BbsDelete(int seq) throws Exception{
		
		bbsDao.BbsDelete(seq);
	}
	
	public void BbsUpdate(BbsDto dto) throws Exception{
		
		bbsDao.BbsUpdate(dto);
	}
	
	
}
