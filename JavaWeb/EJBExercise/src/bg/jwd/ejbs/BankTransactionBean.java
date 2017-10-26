package bg.jwd.ejbs;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import bg.jwd.ejbs.api.BankTransaction;

/**
 * Session Bean implementation class BankTransactionBean
 */
@Stateful
@LocalBean
public class BankTransactionBean implements BankTransaction
{

	private Map<String, BigDecimal> bankAccounts;
	private String lastUser;
	
	
	
	public BankTransactionBean()
	{
		super();
		this.bankAccounts = new HashMap<>();
	}
	@Override
	public void withdraw(String username, BigDecimal amount) {
		if (!this.bankAccounts.containsKey(username)) {
			throw new IllegalArgumentException("The user does not have an account");
		}
		if (amount.compareTo(BigDecimal.ONE) < 0 ||
				amount.compareTo(this.bankAccounts.get(username).divide(BigDecimal.valueOf(2))) > 1) {
			throw new IllegalArgumentException("Insufficient funds!");
		} 
		this.bankAccounts.put(username, this.bankAccounts.get(username).subtract(amount));
		this.updateLastUser(username);
	}
	@Override
	public void deposit(String username, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("You can not deposit negative number");
		}
		this.bankAccounts.putIfAbsent(username, BigDecimal.ZERO);
		this.bankAccounts.put(username, this.bankAccounts.get(username).add(amount));
		this.updateLastUser(username);
	}
	@Override
	public BigDecimal getLastUserAmount() {
		if (this.lastUser == null) {
			return BigDecimal.ZERO;
		}
		return this.bankAccounts.getOrDefault(this.lastUser, BigDecimal.ZERO);
	}
	
	private void updateLastUser(String username) {
		this.lastUser = username;
	}
}
