<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>List Customers</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				
				<!-- add out html table here -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					
					<!-- loop over and print our customers -->
					<c:forEach items="${ customers }" var="customer">
						<tr>
							<td><c:out value="${customer.firstName}" /></td>
							<td><c:out value="${customer.lastName}" /></td>
							<td><c:out value="${customer.email}" /></td>
						</tr>
					</c:forEach>
				</table>
				
				
			</div>
		</div>
	</body>
</html>