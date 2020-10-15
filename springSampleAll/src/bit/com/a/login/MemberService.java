package bit.com.a.login;

import java.util.List;

import bit.com.a.dto.MemberDto;

public interface MemberService {

	public void addMember(MemberDto dto) throws Exception;
	
	public MemberDto loginMember(MemberDto dto) throws Exception;
	
	int getId(MemberDto mem);
}
