package bg.jwd.bank.dtos;

public class AccountDto
{
	private String username;
	private String accountNumber;
	private String amount;
	private String currency;
	
	public AccountDto()
	{
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String client)
	{
		this.username = client;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(String operation)
	{
		this.accountNumber = operation;
	}
	public String getAmount()
	{
		return amount;
	}
	public void setAmount(String transactionAmount)
	{
		this.amount = transactionAmount;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}
	
	
}
