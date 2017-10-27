package bg.jwd.bank.entities;

import java.math.BigDecimal;

import bg.jwd.bank.enums.Currency;

public class BankAccount
{
	private String username;
	private String accountNumber;
	private BigDecimal amount;
	private Currency currency;
	private String creator;	

	public BankAccount()
	{
	}

	public BankAccount(String username, String accountNumber, BigDecimal amount, Currency currency)
	{
		this.username = username;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.currency = currency;
	}		

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	public Currency getCurrency()
	{
		return currency;
	}

	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}

	public void subtractAmount(BigDecimal amount)
	{
		this.amount = this.amount.subtract(amount);
	}

	public void addAmount(BigDecimal amount)
	{
		this.amount = this.amount.add(amount);
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	public String getCreator()
	{
		return creator;
	}

	public void setCreator(String creator)
	{
		this.creator = creator;
	}
}
