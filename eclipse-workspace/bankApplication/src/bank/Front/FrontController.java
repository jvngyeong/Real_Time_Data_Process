package bank.Front;
import java.util.List;

import bank.Request;
import bank.model.AccountDTO;
import bank.service.AccountListService;
import bank.service.AccountService;
import bank.service.AccountWriteService;
import bank.service.DepositService;
import bank.service.WithDrawService;
import bank.view.AccountCreate;
import bank.view.AccountDepositView;
import bank.view.AccountListView;
import bank.view.AccountWithDrawView;
import bank.view.DepositView;
import bank.view.MainPage;
import bank.view.WithDrawView;

public class FrontController {
	public static void main(String[] args) {
		int pageNum = 0;	//메인 페이지
		boolean run = true;
		Request request = null;
		while(run) {
			if(pageNum == 0) {
				//메인 페이지
				MainPage mainPage = new MainPage();
				request = mainPage.view();
				pageNum = request.getPageNum();
			}
			else if(pageNum == 1) {
				//계좌 정보 입력
				AccountCreate accountCreate = new AccountCreate();
				request = accountCreate.view();
				pageNum = request.getPageNum();
			}
			else if(pageNum == 6) {
				//계좌 생성
				AccountWriteService action = new AccountWriteService();
				action.execute(request);
				pageNum = 0;
			}
			else if(pageNum == 2) {
				//계좌 목록
				System.out.println("계좌목록");
				AccountListService action = new AccountListService();
				List<AccountDTO> list = action.execute();
				//출력
				AccountListView accountListView = new AccountListView();
				accountListView.view(list);
				pageNum = 0;
			}
			else if(pageNum == 3) {
				//입금 정보 입력
				DepositView depositView = new DepositView();
				request = depositView.view();
				pageNum = request.getPageNum();
			}
			else if(pageNum == 7) {
				// 계좌 정보에 해당되는 계좌 정보
				AccountService action = new AccountService();
				AccountDTO dto = action.execute(request);
				AccountDepositView accountDepositView = new AccountDepositView();
				request = accountDepositView.view(dto);
				pageNum = request.getPageNum();
			}
			else if(pageNum == 8) {
				DepositService action = new DepositService();
				action.execute(request);
				pageNum = 0;
			}
			else if(pageNum == 4) {
				//출금할 계좌 정보 입력
				WithDrawView withDrawView = new WithDrawView();
				request = withDrawView.view();
				pageNum = request.getPageNum();
			}
			else if(pageNum == 9) {
				AccountService action = new AccountService();
				AccountDTO dto = action.execute(request);
				AccountWithDrawView accountWithDrawView = new AccountWithDrawView();
				request = accountWithDrawView.view(dto);
				pageNum = request.getPageNum();
			}
			else if(pageNum == 10) {
				WithDrawService action = new WithDrawService();
				action.execute(request);
				pageNum = 0;
			}
			else if(pageNum == 5) {
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
			}
		}
	}
}
