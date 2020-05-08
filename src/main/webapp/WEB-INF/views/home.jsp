<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
		<hr width="500" color="skyblue">
		<h3>EMP 메인 페이지</h3>
		<hr width="500" color="skyblue">
		<br/><br/>
		
		<a href="<%=request.getContextPath() %>/emp_list.do">[전체목록]</a>
	</div>

</body>
</html>
