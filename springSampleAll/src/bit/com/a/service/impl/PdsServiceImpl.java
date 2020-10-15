package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;
import bit.com.a.service.PdsService;


@Service
public class PdsServiceImpl implements PdsService {

	
	@Autowired
	PdsDao dao;

	@Override
	public List<PdsDto> getPdsList( PdsParam param ) {
		
		return dao.getPdsList(param);
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		
		return dao.uploadPds(dto);
	}

	@Override
	public PdsDto detailPds(int seq) {
		
		return dao.detailPds(seq);
	}

	@Override
	public boolean updatePds(PdsDto pds) {

		return dao.updatePds(pds);
	}

	@Override
	public boolean deletePds(int seq) {

		return dao.deletePds(seq);
	}
	
	
	
	
}
