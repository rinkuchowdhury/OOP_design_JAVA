<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc form tag confirmation</title>
</head>
<body>

	the student name is: ${student.firstName} ${student.lastName}
	<br><br>
	Free Passes: ${student.freePasses}
	<br><br>
	Postal Code: ${student.postalCode}
	<br><br>
	Country: ${student.country}
	<br><br>
	Language: ${student.language}
	<br><br>
	CC: ${student.courseCode}
	<br><br>
	OS: 
	<ul>
		<c:forEach var="temp" items="${student.os}">
		<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>