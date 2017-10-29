package bg.jwd.bank.db;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bg.jwd.bank.dtos.AccountDto;
import bg.jwd.bank.entities.BankAccount;
import bg.jwd.bank.enums.Currency;
import bg.jwd.bank.utils.UserUtils;

@Scope(value = "singleton")
@Component
public class BankAccountsDB
{
	private Map<String, BankAccount> bankAccounts = new HashMap<String, BankAccount>();	
	
	public BankAccountsDB()
	{
		// this.bankAccounts.put("1234", new BankAccount("Pesjo", "1234", new BigDecimal("21415"), Currency.EUR));
	}

	public void withdraw(String accountNumber, BigDecimal amount, String currency)
	{
		if (!this.bankAccounts.containsKey(accountNumber))
		{
			throw new IllegalArgumentException("The user does not have an account");
		}
		
		BankAccount currentAcc = this.bankAccounts.get(accountNumber);
		Currency inputCurrency = Currency.valueOf(currency.toUpperCase());
		
		
		if(!currentAcc.getCurrency().equals(inputCurrency)) 
		{
			BigDecimal levaValue = amount.multiply(BigDecimal.valueOf(inputCurrency.getBuyRate()));
			amount = levaValue.divide(BigDecimal.valueOf(currentAcc.getCurrency().getSellRate()), 20, RoundingMode.HALF_UP);
		}
		
		if (amount.compareTo(BigDecimal.ONE) < 0
				|| amount.compareTo(this.bankAccounts.get(accountNumber).getAmount().divide(BigDecimal.valueOf(2))) > 0)
		{
			throw new IllegalArgumentException("Insufficient funds!");
		}
		
		currentAcc.subtractAmount(amount);
	}

	public void deposit(String accountNumber, BigDecimal amount, String currency)
	{
		if (amount.compareTo(BigDecimal.ZERO) <= 0)
		{
			throw new IllegalArgumentException("You can not deposit negative number");
		}
		
		if (this.bankAccounts.containsKey(accountNumber)) {
			BankAccount currentAcc = this.bankAccounts.get(accountNumber);
			Currency inputCurrency = Currency.valueOf(currency.toUpperCase());
			if (currentAcc.getCurrency().equals(inputCurrency)) {
				currentAcc.addAmount(amount);
			}			
			else 
			{
				BigDecimal levaValue = amount.multiply(BigDecimal.valueOf(inputCurrency.getBuyRate()));
				BigDecimal finalValue = levaValue.divide(BigDecimal.valueOf(currentAcc.getCurrency().getSellRate()), 20, RoundingMode.HALF_UP);
				currentAcc.addAmount(finalValue);
			}
		}
		else 
		{
			throw new IllegalArgumentException("The account does not exist");
		}
	}
	
	public void saveBankAccount(AccountDto account) {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.setAccountNumber(account.getAccountNumber());
		bankAccount.setAmount(new BigDecimal(account.getAmount()));
		bankAccount.setCurrency(Currency.valueOf(account.getCurrency()));
		bankAccount.setUsername(account.getUsername());
		bankAccount.setCreator(UserUtils.getUser().getUsername());
		
		this.bankAccounts.put(account.getAccountNumber(), bankAccount);
	}

	public Collection<BankAccount> getBankAccounts() {		
		return Collections.unmodifiableCollection(this.bankAccounts.values());
	}
}
