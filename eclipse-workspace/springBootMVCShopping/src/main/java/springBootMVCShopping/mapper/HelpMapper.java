package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.AuthInfoDTO;

@Mapper
public interface HelpMapper {

	public String findId(String userPhone, String userEmail);

	public AuthInfoDTO findPw(String userId, String userPhone);

	public void changePw(AuthInfoDTO auth);
	
}
