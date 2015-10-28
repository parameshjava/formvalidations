<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
<head>
	<title>Customer Saved Successfully</title>
</head>
<body>
<h3>
	Customer Saved Successfully.
</h3>

<strong>Customer Name:${customerVO.name}</strong><br>
<strong>Customer Email:${customerVO.email}</strong><br>
<strong>Customer Age:${customerVO.age}</strong><br>
<strong>Customer Gender:${customerVO.gender}</strong><br>
<strong>Customer Birthday:<fmt:formatDate value="${customerVO.birthday}" type="date" /></strong><br>

</body>
</html>
