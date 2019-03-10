<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring rest demo</title>
</head>
<body>
	<h3>Hello rest api demo </h3>
	
	<a href="${pageContext.request.contextPath}/test/hello">Hello API</a>
	<br></br>
	<a href="${pageContext.request.contextPath}/api/student">Get all student</a>
</body>
</html>