<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
			<hr width="500" color="tomato"/>
				<h3>EMP 테이블 수정폼</h3>
			<hr width="500" color="tomato"/>
			<br/><br/>
			<form method="post" action="<%=request.getContextPath() %>/emp_updateOk.do">
			<table border="1" cellspacing="0" width="350">
				<c:set var="dto" value="${modify }"/>
				<c:if test="${!empty dto }">
					<tr>
						<th>사원번호</th>
						<td>${dto.getEmpno() }
									<input type="hidden" value="${dto.getEmpno() }" name="empno">
						</td>
					</tr>
					<tr>
						<th>사원며ㅛㅇ</th>
						<td>${dto.getEname() }</td>
					</tr>
					<tr>
						<th>담당업무</th>
						<td>${dto.getJob() }</td>
					</tr>
					<tr>
						<th>관리자번호</th>
						<td>${dto.getMgr() }</td>
					</tr>
					<tr>
						<th>급여</th>
						<td><input type="text" value="${dto.getSal() }" name="sal"></td>
					</tr>
					<tr>
						<th> 보너서,</th>
						<td><input type="text" value="${dto.getComm() }" name="comm"></td>
					</tr>
					<tr>
						<th>부서번호</th>
						<td>${dto.getDeptno() }</td>
					</tr>
					<tr>
						<th>입사일자</th>
						<td>${dto.getHiredate().substring(0,10) }</td>
					</tr>
				</c:if>
				<c:if test="${empty dto }">
				<tr>
						<td colspan="2" align="center"><h3>검색된 레코드가 없습니다.</h3></td>
					</tr>
				</c:if>
			
				
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정"> 
						<input type="button" value="삭제" onclick="location.href='emp_delete.do?empno=${dto.getEmpno() }'"> 
						<input type="button" value="목ㄺ" onclick="location.href='emp_list.do'"> 
					</td>
				</tr>
			</table>
			</form>
		</div>
</body>
</html>