<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
	<title>Registration form</title>
	<style>
		.error{color:red}
	</style>
	
</head>
<body>

	<i>Fill out the from.Asterisk (*) means required.</i>
	<br><br>
	
	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name (*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		Free Passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"></form:errors>
		<br><br>
		
		Postal Code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"></form:errors>
		<br><br>
		
		Country Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"></form:errors>
		<br><br>
		
		
		Country:
		<form:select path="country">
			<form:options items="${theCountryOptions}"></form:options>	
		</form:select>
		<br><br>
		Favourite Language:
		 <form:radiobuttons path="language" items="${student.languageOption}"  />
		<br><br>
		Operating Systems:
		 <form:checkboxes path="os" items="${student.osOption}"/>
		 
		<br><br>
		<input type="submit" value="Submit"/>
	
	</form:form>
</body>
</html>