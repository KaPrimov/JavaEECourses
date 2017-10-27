package bg.jwd.bank.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.bank.db.BankAccountsDB;
import bg.jwd.bank.dtos.OperationDto;
import bg.jwd.bank.enums.Currency;

@Controller
public class OperationController
{
	@Autowired
	private BankAccountsDB bankAccountsDB;

	@RequestMapping(value = "/operation", method = RequestMethod.GET)
	public String getNewAccountView(Model model)
	{
		return "operation";
	}

	@RequestMapping(value = "/operation", method = RequestMethod.POST)
	public String postNewAccount(@ModelAttribute("operation") OperationDto account, Model model)
	{
		String accountNumber = account.getAccountNumber();
		String currency = account.getCurrency();
		BigDecimal amount = new BigDecimal(account.getTransactionAmount());
		try
		{
			if (account.getOperationType().trim().toLowerCase().equals("deposit"))
			{
				this.bankAccountsDB.deposit(accountNumber, amount, currency);
			} else if (account.getOperationType().trim().toLowerCase().equals("withdraw"))
			{
				this.bankAccountsDB.withdraw(accountNumber, amount, currency);
			}
		} catch (IllegalArgumentException iae)
		{
			model.addAttribute("error", iae);
		}

		return "operation";
	}
}
