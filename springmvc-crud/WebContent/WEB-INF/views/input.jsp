<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="testConversionServiceConverter" method="post">
		<!-- 格式：lastname-email-gender-department.id -->
		Employee:<input type="text" name="employee" />
		<input type="submit" value="submit" />
	</form>
	<br>

	<!-- 
		1.为什么使用form标签？
		可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
		2.注意
		可以通过modelAttribute属性指定绑定的模型属性，若没有指定该属性，则
		默认从request域对象中读取command所对应的bean，如果该属性值也不存在，
		则发生错误
	 -->
	 
	 <!-- SpringMVC表单标签 -->
	 <form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
	 	
	 	<!-- path属性对应html标签的name属性值 -->
	 	
	 	<!-- employee.id为空 为添加 -->
	 	<c:if test="${employee.id == null }">
	 		LastName:<form:input path="lastName"/>
	 	</c:if>
	 	<c:if test="${employee.id != null }">
	 		<form:hidden path="id"/>
	 		<!-- 
	 			对应_method不能使用form:hidden标签，因为modelAtrribute对应的bean中 
	 			没有_method这个属性
	 		-->
	 		<!-- put方法 -->
	 		<input type="hidden" name="_method" value="PUT" />
	 	</c:if>
	 	
	 	<br>
	 	Email:<form:input path="email"/>
	 	<br>
	 	<%
	 		Map<String, String> genders = new HashMap<>();
	 		genders.put("1", "Male");
	 		genders.put("0", "Female");
	 		request.setAttribute("genders", genders);
	 	%>
	 	Gender:<form:radiobuttons path="gender" items="${genders }"/>
	 	<br>
	 	Department:
	 	<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
	 	<br>
	 	<!--  新增一个生日-->
	 	<!--  
	 		1.数据类型转换
	 		2.数据类型格式化
	 		3.数据校验的问题
	 	-->
	 	birth：<form:input path="birth"/>
	 	<br>
	 	
	 	<input type="submit" value="submit" />
	 </form:form>

</body>
</html>