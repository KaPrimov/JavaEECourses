package bg.jwd.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.ejbs.api.BankTransaction;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BankTransaction bankTransaction;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		BigDecimal lastAmount = bankTransaction.getLastUserAmount();
		request.setAttribute("amount", lastAmount);
		httpRequest.getRequestDispatcher("/page/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("operation");
		BigDecimal amount = new BigDecimal(request.getParameter("transactionAmount"));
		String client = request.getParameter("client");
		
		if (mode.toLowerCase().trim().equals("deposit")) {
			this.bankTransaction.deposit(client, amount);
		} else if (mode.toLowerCase().trim().equals("withdraw")) {
			this.bankTransaction.withdraw(client, amount);
		}
		this.doGet(request, response);
	}

}
