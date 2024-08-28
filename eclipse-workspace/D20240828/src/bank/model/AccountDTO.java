package bank.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	int accountNo;
	String owner;
	int balance;
}
