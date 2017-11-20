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
<script type="text/javascript" src="scripts/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#testJson").click(function(){
			
			var url = this.href;
			var args = {};
			$.post(url, args, function(data){
				for(var i=0;i<data.length;i++){
					var id=data[i].id;
					var lastName = data[i].lastName;
					alert(id + " : " + lastName);
				}
			});
			
			return false;
		})

		
	})

</script>
</head>
<body>

	<a href="emps">List Employees</a>
	<br>
	<a href="testJson" id="testJson">Test Json</a>
	

</body>
</html>