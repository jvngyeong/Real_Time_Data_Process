package bank.service;

import bank.Request;
import bank.model.AccountDAO;
import bank.model.AccountDTO;

public class DepositService {
	public Request execute(Request request) {
		AccountDTO dto = new AccountDTO();
		dto.setAccountNo(request.getAccountNo());
		dto.setBalance(request.getBalance());
		AccountDAO dao = new AccountDAO();
		dao.depositUpdate(dto);
		return request;
	}
}
