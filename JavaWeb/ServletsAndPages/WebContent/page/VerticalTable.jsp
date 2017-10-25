<%@page import="java.util.Date"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="date" value="<%=new Date()%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vertical Table</title>
</head>
<body>
	<ct:page date='false'>
		<jsp:body>
		<table id="vertical-1" border=1>
			<tr>
				<th>Course</th>
				<td>JavaWeb</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${date}</td>
			</tr>
		</table>
		</jsp:body>
	</ct:page>
</body>
</html>