package bg.jwd.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.bank.db.BankAccountsDB;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	@Autowired
	private BankAccountsDB bankAccountsDB;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model)
	{
		model.addAttribute("accounts", this.bankAccountsDB.getBankAccounts());
		System.out.println(this.bankAccountsDB.getBankAccounts());
		return "index";
	}	
}
