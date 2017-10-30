<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags"%>
<html>
<body>
<ct:Header />
	<table border="1">
			<thead>
				<tr>
					<td>Brand</td>
					<td>Model</td>
					<td>Price</td>
					<td>Owner Username</td>
				</tr>
			</thead>
			<c:if test="${not empty cars}">
		    	<tbody>
			        <c:forEach var="car" items="${cars}">
			            <tr>
			                <td>${car.brand}</td>
			                <td>${car.model}</td>
			                <td>${car.price}</td>
			                <td>${car.userUsername}</td>
			            </tr>
			        </c:forEach>
		        </tbody>
			</c:if>
		</table>
</body>
<ct:Footer />
</html>
