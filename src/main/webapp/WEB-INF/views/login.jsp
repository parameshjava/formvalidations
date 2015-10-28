<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Captcha Demo</title>
	<style>
		.error {
			color: red;
		}
		
		.refresh_btn {
			height: 30;
			width: 30;
		}
	</style>

</head>

<body>

	<form:form action="login" method="post" commandName="loginVO">
		<div class="login">
			<table border="0" align="center">
				<tr>
					<td align="center"><h1>Login</h1></td>
				</tr>
				<tr>
					<td colspan="3"><font color="red"><c:out value="${message}"></c:out></font></td>
				</tr>
				<tr>
					<td>Enter User Id</td>
					<td><form:input path="userId" autocompletee="off"/></td>
					<td><form:errors path="userId" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter Password</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter below Text</td>
					<td><form:input path="captcha" autocomplete="off"/></td>
					<td><form:errors path="captcha" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Captcha</td>
					<td>
						<div>
							<img id="captcha_id" name="imgCaptcha" src="captcha.jpg">
						</div>
					</td>
					<td align="left">
						<a href="javascript:;" title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
							<img src="resources/images/refresh_btn.png" class="refresh_btn"/>
					</a></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login" /></td>
				</tr>

			</table>
		</div>

	</form:form>


</body>
</html>