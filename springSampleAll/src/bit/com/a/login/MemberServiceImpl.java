package bit.com.a.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dto.MemberDto;

@Service	// controller, dao 중간에 위치.... DB데이터 가공
public class MemberServiceImpl implements MemberService {

	@Autowired				// ioc
	MemberDao memberDao;	// MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public void addMember( MemberDto dto) throws Exception {		
		memberDao.addMember(dto);
	}

	@Override
	public MemberDto loginMember(MemberDto dto) throws Exception{
		MemberDto rdto = memberDao.loginMember(dto);
		return rdto;
	}
	
	@Override
	public int getId(MemberDto mem) {		
		return memberDao.getId(mem);		
	}
}





