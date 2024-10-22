package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.MemberDTO;

@Mapper
public interface MemberInfoMapper {

	public MemberDTO memberSelectOne(String memberId);

	public void memberUpdate(MemberDTO dto);

	public void memberPwUpdate(@Param("newPw") String newPw, @Param("memberId") String userId);

	public void memberDrop(String userId);
}
