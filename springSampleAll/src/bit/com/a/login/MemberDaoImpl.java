package bit.com.a.login;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Repository	// = 저장소
public class MemberDaoImpl implements MemberDao {

	@Autowired		// DI
	SqlSession sqlSession;		// SqlSession sqlSession = new SqlSessiontemplate();
	
	String namespace = "Member.";
	
	@Override
	public void addMember(MemberDto dto) throws Exception {
		 sqlSession.insert(namespace + "addMember", dto);
	
	}
	
	@Override
	public MemberDto loginMember(MemberDto dto) throws Exception {
		MemberDto rdto = sqlSession.selectOne(namespace+"loginMember", dto);
		return rdto;
	}
	
	@Override
	public int getId(MemberDto mem) {		
		return sqlSession.selectOne(namespace + "getId", mem);
	}

	
}









