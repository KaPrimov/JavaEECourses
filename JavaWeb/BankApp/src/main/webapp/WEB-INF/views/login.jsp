<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bank System</title>
</head>
<body>
	<ct:Header title="Home" />

	<form name="login" action="/bank-1.0.0-BUILD-SNAPSHOT/login" method="POST">
		<label>Username</label> <input id="username" name="username"
			type="text" /> <label>Password</label> <input id="password"
			name="password" type="password" /> <input name="submit"
			type="submit" value="Login" />
		<%-- 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
	</form>
	<ct:Footer/>
</body>
</html>