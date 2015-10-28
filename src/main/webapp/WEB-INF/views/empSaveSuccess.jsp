<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Employee Saved Successfully</title>
	</head>
	<body>
		<h3>Employee Saved Successfully.</h3>
	
		<strong>Employee ID:${employeeVO.id}</strong>
		<br>
		<strong>Employee Name:${employeeVO.name}</strong>
		<br>
		<strong>Employee Role:${employeeVO.role}</strong>
		<br>
	
	</body>
</html>
