<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form:form modelAttribute="user"
		action="${pageContext.request.contextPath }/user/register.do"
		method="post">
   邮箱:<form:input path="email" />
		<form:errors path="email"></form:errors>
		<br />
 密码:<form:password path="password" />
		<form:errors path="password"></form:errors>
		<br />
		<input type="submit" value="注册">
	</form:form>

</body>
</html>