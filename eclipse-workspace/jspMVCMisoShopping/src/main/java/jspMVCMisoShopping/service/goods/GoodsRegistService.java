package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsRegistService {
	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int fileSize = 1024 * 1024 * 100;
		String realPath = req.getServletContext().getRealPath("/goods/upload");
		System.out.println(realPath);
		try {
			MultipartRequest multi = new MultipartRequest(req, realPath, fileSize, "utf-8",
					new DefaultFileRenamePolicy());
			
			String storeMainImage = multi.getFilesystemName("mainImage");
			String mainImage = multi.getOriginalFileName("mainImage");
			
			String storeImage1 = multi.getFilesystemName("image1");
			String image1 = multi.getOriginalFileName("image1");
			
			String storeImage2 = multi.getFilesystemName("image2");
			String image2 = multi.getOriginalFileName("image2");
			
			String storeImage3 = multi.getFilesystemName("image3");
			String image3 = multi.getOriginalFileName("image3");
			
			String goodsDetailStoreImage = storeImage1 + "`" + storeImage2 + "`" + storeImage3 + "`";
			String goodsDetailImage = image1 + "`" + image2 + "`" + image3;
			
			GoodsDTO dto = new GoodsDTO();
			dto.setGoodsNum(multi.getParameter("goodsNum"));
			dto.setGoodsName(multi.getParameter("goodsName"));
			dto.setGoodsPrice(Integer.parseInt(multi.getParameter("goodsPrice")));
			dto.setGoodsContent(multi.getParameter("goodsContent"));
			GoodsDAO dao = new GoodsDAO();
			HttpSession session = req.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String empId = auth.getUserId();
			EmployeeDAO empDAO = new EmployeeDAO();
			String empNum = empDAO.employeeNumSelect(empId);
			dto.setGoodsMainImage(mainImage);
			dto.setGoodsMainStoreImage(storeMainImage);
			dto.setGoodsDetailImage(goodsDetailImage);
			dto.setGoodsDetailStoreImage(goodsDetailStoreImage);
			dao.goodsInsert(dto, empNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
