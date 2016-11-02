<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="scripts/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

	$(function(){
		/* 把get请求转为post请求，post请求会被转为delete请求 */
		$('.delete').click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		})
		
	})

</script>
</head>
<body>
	
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>	
	
	
	<c:if test="${empty requestScope.employees }">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<thead>
				<tr>
					<th>ID</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Department</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.employees }" var="employee">
					<tr>
						<td>${employee.id }</td>
						<td>${employee.lastName }</td>
						<td>${employee.email }</td>
						<td>${employee.gender == '0' ? 'Female' : 'Male' }</td>
						<td>${employee.department.departmentName }</td>
						<td><a href="emp/${employee.id  }">Edit</a></td>
						<td><a class="delete" href="emp/${employee.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<a href="emp">Add New Employee</a>

</body>
</html>