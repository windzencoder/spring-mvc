<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	
	success page
<%-- 	<br>
	time:${requestScope.time}
	<br>
	names:${requestScope.names}
	<br>
	user:${requestScope.user}
	<br>
	user:${sessionScope.user}
	<br>
	school:${requestScope.school}
	<br>
	school:${sessionScope.school} --%>
	<br>
<%-- 	abc:${requestScope.abc}
	<br>
	user:${requestScope.user} --%>
	
	<fmt:message key="i18n.username"></fmt:message>
	<fmt:message key="i18n.password"></fmt:message>
	
	
</body>
</html>