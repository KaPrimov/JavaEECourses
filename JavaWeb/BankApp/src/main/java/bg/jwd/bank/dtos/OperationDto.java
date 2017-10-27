package bg.jwd.bank.dtos;

import java.math.BigDecimal;

import bg.jwd.bank.enums.Currency;

public class OperationDto
{
	private String accountNumber;
	private String operationType;
	private String transactionAmount;
	private String currency;
	
	
	
	public OperationDto()
	{
	}

	public OperationDto(String accountNumber, String operationType, String transactionAmount, String currency)
	{
		this.accountNumber = accountNumber;
		this.operationType = operationType;
		this.transactionAmount = transactionAmount;
		this.currency = currency;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getOperationType()
	{
		return operationType;
	}

	public void setOperationType(String operationType)
	{
		this.operationType = operationType;
	}

	public String getTransactionAmount()
	{
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount)
	{
		this.transactionAmount = transactionAmount;
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
