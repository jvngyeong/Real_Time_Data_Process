package springBootMVCShopping.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.repository.InquireRepository;

@Controller
@RequestMapping("inquire")
public class InquireController {
	@Autowired
	MemberMapper memberMapper;

	@Autowired
	InquireRepository inquireRepository;
	
	@Autowired
	EmployeeMapper employeeMapper;

	@GetMapping("inquireWrite")
	public String inquireWrite(@ModelAttribute("goodsNum") String goodsNum) {
		return "thymeleaf/inquire/inquireWrite";
	}

	@PostMapping("inquireWrite")
	public void inquireWrite(InquireDTO inquireDTO, HttpSession session, HttpServletResponse response) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getUserId());
		inquireDTO.setMemberNum(memberNum);
		inquireRepository.inquireInsert(inquireDTO);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>";
			str += "window.self.close();";
			str += "</script>";
			out.print(str);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("inquireDelete")
	public @ResponseBody void inquireDelete(String inquireNum) {
		inquireRepository.inquireDelete(inquireNum);
	}
	
	@GetMapping("inquireUpdate")
	public String inquireUpdate(Model model, Integer inquireNum) {
		List<InquireDTO> list = inquireRepository.inquireList(null, inquireNum);
		model.addAttribute("list", list);
		return "thymeleaf/inquire/goodsInquireUpdate";
	}
	
	@PostMapping("inquireUpdate")
	public void inquireUpdate(HttpServletResponse response, InquireDTO inquireDTO) {
		inquireRepository.inquireUpdate(inquireDTO);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>";
			str += "opener.parent.inquire();";
			str += "window.self.close();";
			str += "</script>";
			out.print(str);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("goodsQuestion")
	public String goodsQuestion(Model model) {
		List<InquireDTO> list = inquireRepository.inquireList(null, null);
		model.addAttribute("list", list);
		return "thymeleaf/inquire/goodsQuestion";
	}
	
	@GetMapping("inquireAnswer")
	public String inquireAnswer(Integer inquireNum, Model model) {
		List<InquireDTO> list = inquireRepository.inquireList(null, inquireNum);
		model.addAttribute("list", list);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/inquire/inquireAnswer";
	}
	
	@PostMapping("inquireAnswer")
	public String inquireAnswer(InquireDTO inquireDTO, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = employeeMapper.empNumSelect(auth.getUserId());
		inquireDTO.setEmpNum(empNum);
		inquireRepository.inquireAnswerUpdate(inquireDTO);
		return "redirect:goodsQuestion";
	}
}
