<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<header>
	<c:if test="${not empty error}" >
		<h1>error.getMessage()</h1>
	</c:if>
	<a href="/bank-1.0.0-BUILD-SNAPSHOT/">Home</a>
	<a href="/bank-1.0.0-BUILD-SNAPSHOT/new-account">New Account</a>
	<a href="/bank-1.0.0-BUILD-SNAPSHOT/operation">Operations</a>
</header>
<h2>${title}</h2>