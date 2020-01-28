<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- case 1:运行项目 -->
	<a href ="SpringMVCHandler/welcome1">First springmvc</a>
	
	<br>
	
	<!-- case 2: 测试参数params,method-->
	<form action="SpringMVCHandler/welcome2"  method="post">
		name:<input name="name">
		age:<input name="age">
	<!-- 		height:<input name="height"> -->
		<input type="submit" value="post">
	</form>	
	
	
	<!-- case 3: PathVariable动态获得参数-->
	<a href="SpringMVCHandler/welcome3/zs">welcome 3</a>
	
	<br>
	
	<!-- case 4: rest增删改查-->
	
	<form action="SpringMVCHandler/welcome4/1" method="GET">
		<input type="submit" value="查">
	</form>
	
	<!-- case 4: -->
	<form action="SpringMVCHandler/welcome5/1" method="POST">
		<input type="submit" value="增">
	</form>
	
	<!-- case 4: -->
	<form action="SpringMVCHandler/welcome6/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
	  	<input type="submit" value="删">
	</form>
	
	<!-- case 4: -->
	<form action="SpringMVCHandler/welcome7/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="改">
	</form>
	
	<!-- case 4: -->
	<form action="SpringMVCHandler/welcome8" method="post">
		<input name="uname" type="text">
		<input type="submit" value="查">
	</form>
	
	<!-- case 5: test requestheader: -->
	<a href="SpringMVCHandler/testRequestHeader">testRequestHeader</a>
	
	<br>
	
	<!--  case 6: test cookievalue -->
	<a href="SpringMVCHandler/testcookievalue">testcookievalue</a>
	
	<!-- case 7: testObjectProperties -->
	
	<form action="SpringMVCHandler/testObjectProperties">
			id:<input name="id" type="text"/>
			name: <input name="name" type="text"/>
			家庭地址:<input name="address.homeAddress" type="text"/>
			学校地址:<input name="address.schoolAddress" type="text"/>
			<input type="submit" value="查">
	</form>
	
	<br/>
	
	<!-- case 8:testServletAPI -->
		<a href="SpringMVCHandler/testServletAPI">testServletAPI</a>
	
	<br/>
	<!-- case 9:testModelAndView -->
	<br/>
	
	
	<a href="SpringMVCHandler/testModelAndView">testModelAndView</a>
	<br/>
	
	<br/>
	<a href="SpringMVCHandler/testModel">testModel</a>
	<br/>
	
	<br/>
	<a href="SpringMVCHandler/testModelMap">testModelMap</a>
	<br/>
	
	<br/>
	<a href="SpringMVCHandler/testMap">testMap</a>
	<br/>
	
	<!-- testModelAttribute -->
	<form action="SpringMVCHandler/testModelAttribute" method="post">
		编号: <input name="id" type="hidden" value="31" />
		姓名：<input name="name" type="text"/>
		
		<input type="submit" value="修改">
	</form>
	
	
	
</body>
</html>