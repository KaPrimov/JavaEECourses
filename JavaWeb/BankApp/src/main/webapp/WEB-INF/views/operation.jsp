<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bank System</title>
</head>
<body>
	<ct:Header title="Perform Operation"/>
	<form:form method="POST" modelAttribute="operation">
		Account Number:<br> <input type="text" name="accountNumber"/><br>
		Operation:<br> <select name="operationType">
			<option value="deposit">Deposit</option>
			<option value="withdraw">Withdraw</option>
		</select><br>
		Currency:<br> <select name="currency">
			<option value="USD">USD</option>
			<option value="GBP">GBP</option>
			<option value="EUR">EUR</option>
		</select><br>
		Amount of Transaction: <br> <input type="number" name="transactionAmount" min=0/><br>
		<input type="submit" value="Submit" />
	</form:form>
	<ct:Footer />
</body>
</html>