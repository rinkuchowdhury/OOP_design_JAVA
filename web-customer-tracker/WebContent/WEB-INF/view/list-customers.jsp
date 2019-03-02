<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>List Customers</title>
		
		<!-- reference our style sheet -->	
		<link type="text/css" rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css"> 
			  	
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2> CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				
				<!-- put new button: Add Customer -->
				<input class = "add-button" type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
				/>
				
				<!-- put new form: Search box -->	
				<form:form action="search" method="GET">
					Search Customer: <input type="text" name="theSearchName"/> <!-- name field will pass as parameter:line 81 in CustomerController.java -->
					<input type="submit" value="Search" class="add-button"/>
				</form:form>
				
				<!-- add out html table here  -->
				
				<table>
				
					<tr>
						<th>First Name </th>
						<th>Last Name </th>
						<th>Email </th>
						<th>Action </th>
					</tr>
					
					<!-- loop over and print out customers -->
					<c:forEach var="tempCustomer" items="${customers}"> <!-- $customers:line 33,customerController.java --> 
						
						<!-- construct an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
						<!-- construct a delete link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
						<tr>
							<td> ${tempCustomer.firstName} </td> <!-- call tempCustomer.getFirstName() -->
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td> 
							<td> <!-- display Update link -->
								<a href="${updateLink}">Update</a> 
								| 
								<a href="${deleteLink}"
								onclick="if(!(confirm('Are you want to delete this customer?'))) return false">Delete</a>
								
							</td>
							
						</tr>
					</c:forEach>
					
				</table>
			
			</div>
		</div>
	
	</body>

</html>