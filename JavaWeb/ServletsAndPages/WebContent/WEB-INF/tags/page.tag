<%@tag import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="date"%>
<title>Tag Page</title>
<h1>Some content</h1>
<c:if test='${date eq true}'>
	<p><%=new Date()%></p>
</c:if>
<jsp:doBody/>
<footer>
	<p>Version: -0.0.1</p>
</footer>