package springBootMVCShopping.service.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.mapper.HelpMapper;

@Service
public class IdFindService {
	@Autowired
	HelpMapper helpMapper;
	
	public void execute(String userPhone, String userEmail, Model model) {
		String userId = helpMapper.findId(userPhone, userEmail);
		model.addAttribute("userId", userId);
	}
}
