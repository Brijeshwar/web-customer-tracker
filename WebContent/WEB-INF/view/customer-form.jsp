<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Save Customers</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Customer</h3>
			
			<form:form action="saveCustomer" method="POST" modelAttribute="customer">
			
				<!-- need to associate this data with customer id -->
				<form:hidden path="id" />
				
				<table>
					<tr>
						<td><label>First Name:</label>
						<td><form:input path="firstName" />
					</tr>
					
					<tr>
						<td><label>Last Name:</label>
						<td><form:input path="lastName" />
					</tr>
					
					<tr>
						<td><label>Email:</label>
						<td><form:input path="email" />
					</tr>
					
					<tr>
						<td><label></label>
						<td><input type="submit" value="Save" class="save" />
					</tr>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
			
		</div>
	</body>
</html>