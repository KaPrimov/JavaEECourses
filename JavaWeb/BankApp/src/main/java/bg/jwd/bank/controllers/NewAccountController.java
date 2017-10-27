package bg.jwd.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.bank.db.BankAccountsDB;
import bg.jwd.bank.dtos.AccountDto;
import bg.jwd.bank.entities.BankAccount;

@Controller
public class NewAccountController
{
	@Autowired
	private BankAccountsDB bankAccountsDB;

	@RequestMapping(value = "/new-account", method = RequestMethod.GET)
	public String getNewAccountView(Model model)
	{
		return "newAccount";
	}

	@RequestMapping(value = "/new-account", method = RequestMethod.POST)
	public String postNewAccount(@ModelAttribute("account") AccountDto account, Model model)
	{
		this.bankAccountsDB.saveBankAccount(account);
		return "newAccount";
	}
}
