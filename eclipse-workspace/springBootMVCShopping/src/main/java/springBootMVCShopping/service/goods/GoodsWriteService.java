package springBootMVCShopping.service.goods;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		GoodsDTO goodsDTO = new GoodsDTO();
		BeanUtils.copyProperties(goodsCommand, goodsDTO);
		String empNum = employeeMapper.empNumSelect(auth.getUserId());
		goodsDTO.setEmpNum(empNum);
		goodsDTO.setUpdateEmpNum(empNum);
		
		//파일 추가
		//경로 (getResource를 통해 Resources 파일의 경로를 가져오고 그 안의 폴더를 가져옴)
		URL resource = getClass().getClassLoader().getResource("static/upload");
		//String fileDir = resource.getFile();
		String fileDir = "C:\\Real_Time_Data_Process\\eclipse-workspace\\springBootMVCShopping\\target\\classes\\static\\upload";
		
		//메인 이미지
		MultipartFile mf = goodsCommand.getGoodsMainImage();
		String originalFile = mf.getOriginalFilename();
		
		//저장하기 위한 이름 만들기 : UUID (시간으로 랜덤값을 줌)
		//확장자 : .jpg, .png : abcd.abdc.jpg
		String extension = originalFile.substring(originalFile.lastIndexOf('.'));
		
		//이름 짓기
		String storeName = UUID.randomUUID().toString().replace("-", "");
		String storeFileName = storeName + extension;
		// 파일명 생성!! (파일을 만든게 아니라 이름을 만든거임)
		File file = new File(fileDir + "/" + storeFileName);
		
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		goodsDTO.setGoodsMainImage(originalFile);
		goodsDTO.setGoodsMainStoreImage(storeFileName);
		
		//goodsCommand의 getGoodsDetailImage 메서드를 실행시켜서 0번 인덱스의 이름이 비어있지 않다면!
		//배열 객체가 생성되었지만 안이 비어있을 수 있기 때문에 이런 식으로 처리함.
		if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
			String originalTotal = "";
			String storeTotal = "";
			for(MultipartFile mpf : goodsCommand.getGoodsDetailImage()) {
				originalFile = mpf.getOriginalFilename();
				extension = originalFile.substring(originalFile.lastIndexOf('.'));
				storeName = UUID.randomUUID().toString().replace("-", "");
				storeFileName = storeName + extension;
				file = new File(fileDir + "/" + storeFileName);
				try {
					mpf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				originalTotal += originalFile + "/";
				storeTotal += storeFileName + "/";
			}
			goodsDTO.setGoodsDetailImage(originalTotal);
			goodsDTO.setGoodsDetailStoreImage(storeTotal);
		}
		goodsMapper.goodsInsert(goodsDTO);
	}
}
