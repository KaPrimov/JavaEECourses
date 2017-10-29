<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<title>User Registry</title>
	</head>
	<body>
		<h1>
			User Registry!
		</h1>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button type="button" onclick="location = '${contextPath}${addUserUrl}'">Add User</button>
		</sec:authorize>
		<form:form method="GET" action="${contextPath}${userRegisterUrl}" modelAttribute="UserSearch">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"><td>
					<td>Status</td>
					<td><input type="text" name="status"><td>
				</tr>
			</table>
			<input type=submit id="btn1" name="Search"/>
		</form:form>
		
		<table border="1">
			<thead>
				<tr>
					<td>Username</td>
					<td>Status</td>
				</tr>
			</thead>
			<c:if test="${not empty users}">
		    	<tbody>
			        <c:forEach var="s" items="${users}">
			            <tr>
			                <td>${s.username}</td>
			                <td>${s.status}</td>
			            </tr>
			        </c:forEach>
		        </tbody>
			</c:if>
		</table>

		<div>Username: ${user.username}</div>

		<form action="/uni/logout" method="post">
			<input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>