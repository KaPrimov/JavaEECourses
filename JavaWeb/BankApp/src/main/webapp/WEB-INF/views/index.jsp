<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bank System</title>
</head>
<body>
	<ct:Header title="Home"/>
		<table border=1>
			<thead>
				<tr>
					<th>Username</th>
					<th>Account Number</th>
					<th>Current Amount</th>
					<th>Account Currency</th>					
					<th>Created By</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accounts}" var="account">
					<td>${account.username}</td>
					<td>${account.accountNumber}</td>
					<td>${account.amount}</td>
					<td>${account.currency}</td>
					<td>${account.creator}</td>
				</c:forEach>
			</tbody>
		</table>
	<ct:Footer />
</body>
</html>