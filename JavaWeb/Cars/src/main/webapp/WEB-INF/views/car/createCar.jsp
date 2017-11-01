<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<body>
<ct:Header />
	<form:form method="POST" action="${contextPath}${carAddUrl}" modelAttribute="addCarDto">
			<table>
				<tr>
					<td>Brand</td>
					<td><input type="text" name="brand"><td>
					<td>Model</td>
					<td><input type="text" name="model"><td>
					<td>Price</td>
					<td><input type="number" name="price"><td>
				</tr>
			</table>
			<input type=submit name="register-car" value="Register Car"/>
	</form:form>
</body>
<ct:Footer />
</html>
