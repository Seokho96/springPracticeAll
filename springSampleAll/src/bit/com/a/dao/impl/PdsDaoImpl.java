package bit.com.a.dao.impl;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;

@Repository
public class PdsDaoImpl implements PdsDao {
	
	
	@Autowired
	SqlSessionTemplate sql;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> getPdsList( PdsParam param ) {
		
		return sql.selectList(ns +"getPdsList");
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		  
		
		return sql.insert(ns + "uploadPds", dto)>0?true:false;
	}

	@Override
	public PdsDto detailPds(int seq) {
		
		return sql.selectOne(ns + "detailPds" , seq);
	}

	@Override
	public boolean updatePds(PdsDto pds) {
		
		return sql.update(ns + "updatePds", pds)>0?true:false;
	}

	@Override
	public boolean deletePds(int seq) {
		
		return sql.delete(ns +"deletePds", seq)>0?true:false;
	}
	
	
	
	
	

}
