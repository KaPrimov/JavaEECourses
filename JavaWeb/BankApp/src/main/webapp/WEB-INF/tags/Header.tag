<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<header>
	<c:if test="${not empty error}" >
		<h1>error.getMessage()</h1>
	</c:if>
	<a href="${contextPath}/">Home</a>
	<a href="${contextPath}/new-account">New Account</a>
	<a href="${contextPath}/operation">Operations</a>
	<sec:authorize access="hasRole('ROLE_USER')">
			<a href="${contextPath}/logout">Logout</a>
	</sec:authorize>
	
</header>
<h2>${title}</h2>