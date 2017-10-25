<%@page import="java.util.Date"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<c:set var="date" value="<%=new Date()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table</title>
</head>
<body>
	<ct:page date='true'>
		<jsp:body>
			<table border=3>
				<tr>
					<th>Topic</th>
					<th>Date</th>
				</tr>
				<tr>
					<td>Java Web</td>
					<td>${date}</td>
				</tr>
			</table>
		</jsp:body>
	</ct:page>

</body>
</html>