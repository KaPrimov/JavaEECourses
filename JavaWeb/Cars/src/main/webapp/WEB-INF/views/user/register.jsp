<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Header />
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form:form method="POST" action="${contextPath}${userRegisterUrl}" modelAttribute="UserRegister">
			<label>Username</label>
			<input id="username" name="username" type="text"/>
			<label>Password</label>
			<input id="password" name="password" type="password" />
			<label>Status</label>
			<input id="status" name="status" type="text" />
			<input name="submit" type="submit" value="Register" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form:form>
	</body>
<ct:Footer />
</html>