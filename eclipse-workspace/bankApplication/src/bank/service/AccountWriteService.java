package bank.service;
// Page Controller

import bank.Request;
import bank.model.AccountDAO;
import bank.model.AccountDTO;

public class AccountWriteService {	
	public void execute(Request request) {
		AccountDTO dto = new AccountDTO();
		dto.setAccountNo(request.getAccountNo());
		dto.setOwner(request.getOwner());
		dto.setBalance(request.getBalance());
		
		AccountDAO dao = new AccountDAO();
		dao.accountInsert(dto);
		System.out.println("계좌가 개설되었습니다.");
	}
}
