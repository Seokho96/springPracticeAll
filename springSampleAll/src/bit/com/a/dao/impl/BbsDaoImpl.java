package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;


@Repository
public class BbsDaoImpl implements BbsDao{

	@Autowired		// DI
	SqlSession sqlSession;
	
	String namespace = "Bbs.";
	@Override
	public List<BbsDto> BbsList(BbsParam search) throws Exception{
		List<BbsDto> list = sqlSession.selectList(namespace + "getBbsList", search);
		//System.out.println(search.getKeyword() + " " + search.getS_category());
		return list;
	}
	@Override
	public int getBbsCount(BbsParam param) {
		
		return sqlSession.selectOne(namespace+"getBbsCount", param);
	}
	
	@Override
	public boolean BbsWrite(BbsDto dto) throws Exception{
		
	  	try {
	  		
	  		sqlSession.insert(namespace + "writeBbs", dto);
	  		
	  	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			
		}
	    return true;
	}
	@Override
	public BbsDto BbsDetail( int seq ) throws Exception {
		
		BbsDto dto = sqlSession.selectOne(namespace +"bbsDetail", seq);
		
		return dto;
	}
	@Override
	public void BbsDelete(int seq) throws Exception{
		
		sqlSession.delete(namespace + "bbsDelete", seq);
	
	}
	@Override
	public void BbsUpdate(BbsDto dto) throws Exception{
		
		sqlSession.update(namespace + "bbsUpdate", dto);
	}
}
