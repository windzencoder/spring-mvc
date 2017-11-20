<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	<form action="springmvc/testFileUpload" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file"/>
		Desc:<input type="text" name="desc"/>
		<input type="submit" value="submit"/>
	</form>

	<a href="springmvc/testView">testView</a>
	<br>

	<a href="springmvc/testViewAndViewResolver">testViewAndViewResolver</a>
	<br>

	<form action="springmvc/testModelAttribute" method="post">
	
		<input type="hidden" name="id" value="1" />
		username:<input type="text" name="username" value="tom"/>
		<br>
		email:<input type="text" name="email" value="123@123.com"/>
		<br>
		age:<input type="text" name="age" value="12"/>
		<br>
		<input type="submit" value="submit" />
	</form>




	<br>
	

	<a href="springmvc/testSessionAttributes">testSessionAttributes</a>
	<br>
	
	<a href="springmvc/testMap">testMap</a>
	
	<br>

	<br>
	
	<a href="springmvc/testModelAndView">testModelAndView</a>
	
	<br>

	<a href="springmvc/testRequestHeader">testRequestHeader</a>
	

	<br>


	<a href="springmvc/testRequestParam?username=hello&age=11">testRequestParam</a>
	

	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>

	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>

	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>


	<br>

	<a href="springmvc/testPathVariable/1">TestPathVariable</a>

	<br>
	

	<form action="springmvc/testMethod" method="post">
		<input type="submit"/>
	</form>
	
	<a href="springmvc/testParamsAndHeaders?username=123&age=1">testParamsAndHeaders</a>

	<a href="springmvc/testMethod">testMethod</a>
	<a href="helloworld">HelloWorld</a>
</body>
</html>