<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank System</title>
</head>
<body>
	<ct:Header title="Web Banking Page"/>
	<form method="post">
		Client:<br> <input type="text" name="client"/><br>
		Bank Account Amount:<br> <input type="number" value="${amount}" disabled/> <br>
		Operation:<br> <select name="operation">
			<option value="deposit">Deposit</option>
			<option value="withdraw">Withdraw</option>
		</select><br>
		Amount of Transaction: <br> <input type="number" name="transactionAmount" min=0/><br>
		<input type="submit" value="Submit" />
	</form>
	<ct:Footer />
</body>
</html>