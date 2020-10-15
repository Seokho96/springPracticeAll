package bit.com.a.dao;

import java.util.List;


import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;

public interface PdsDao {
	
	List<PdsDto> getPdsList( PdsParam param); 
	
	boolean uploadPds(PdsDto dto);
	
	PdsDto detailPds(int seq);
	
	boolean updatePds( PdsDto pds );
	
	boolean deletePds(int seq);

}
