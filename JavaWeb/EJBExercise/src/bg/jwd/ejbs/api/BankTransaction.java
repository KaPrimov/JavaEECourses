package bg.jwd.ejbs.api;

import java.math.BigDecimal;

import javax.ejb.Local;

@Local
public interface BankTransaction
{

	void withdraw(String username, BigDecimal amount);

	BigDecimal getLastUserAmount();

	void deposit(String username, BigDecimal amount);

}
