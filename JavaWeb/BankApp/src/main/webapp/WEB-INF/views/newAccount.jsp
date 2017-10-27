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
	<ct:Header title="New Account"/>
	<form:form method="POST" modelAttribute="account">
		Username:<br> <input type="text" name="username"/><br>
		Account Number: <br> <input type="number" name="accountNumber" min=0/><br>
		Bank Account Amount:<br> <input type="number" name="amount"/> <br>		
		Currency:<br> <select name="currency">
			<option value="USD">USD</option>
			<option value="GBP">GBP</option>
			<option value="EUR">EUR</option>
		</select><br>
		<input type="submit" value="Submit" />
	</form:form>
	<ct:Footer />
</body>
</html>