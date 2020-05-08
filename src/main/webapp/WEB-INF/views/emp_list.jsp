<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="500" color="red">
		<h3>EMP테이블 전체 리스트</h3>
		<hr width="500" color="red">
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>사원번호</th><th>사원명</th>
				<th>담당업무</th><th>입사일</th>
			</tr>
			<c:set var="list" value="${List }"/>
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getEmpno() }</td>
						<td> <a href="emp_cont.do?empno=${dto.getEmpno() }">
							${dto.getEname() }</a></td>
						<td>${dto.getJob() }</td>
						<td>${dto.getHiredate().substring(0,10) }</td>
					</tr>
					</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">ㄷ[ㅔ~이터가없습니다]</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="4" align="right"><input type="button" value="등록" onclick="location.href='emp_insert.do'"> </td>
			</tr>
			
		</table>
	</div>
</body>
</html>