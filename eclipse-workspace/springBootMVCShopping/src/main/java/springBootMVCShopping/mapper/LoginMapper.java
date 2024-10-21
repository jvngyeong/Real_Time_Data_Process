package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {
	public Integer idCheckSelectOne(@Param("userId") String userId);

	public Integer emailCheckSelectOne(String userEmail);

	public AuthInfoDTO loginSelectOne(@Param("userId") String userId);
}
