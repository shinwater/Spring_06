<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="500" color="blue"/>
		<h3>EMP 테이블에 사원ㄷ,옭 폼</h3>
		<hr width="500" color="blue"/>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
		<form method="post" action="<%=request.getContextPath() %>/emp_insertOk.do">
			<table border="0" cellspacing="0" width="300">
					<tr>
						<th align="right">사원번호</th>
						<td><input type="text" name="empno"> </td>
					</tr>
					<tr>
						<th align="right">사원며ㅛㅇ</th>
						<td><input type="text" name="ename"></td>
					</tr>
					<tr>
						<th align="right">담당업무</th>
						<td><input type="text" name="job"></td>
					</tr>
					<tr>
						<th align="right">관리자번호</th>
						<td><input type="text" name="mgr"></td>
					</tr>
					<tr>
						<th align="right">급여</th>
						<td><input type="text" name="sal"></td>
					</tr>
					<tr>
						<th align="right"> 보너서,</th>
						<td><input type="text" name="comm"></td>
					</tr>
					<tr>
						<th align="right">부서번호</th>
						<td><input type="text" name="deptno"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="ㄷ,ㅇ럭"></td>
					</tr>
			
			</table>	
		</form>
	</div>
</body>
</html>