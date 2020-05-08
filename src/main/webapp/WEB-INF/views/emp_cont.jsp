<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- core:if 문이나 반복문에 쓰임 -->
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- fmt:format의 약자.  -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div align="center">
			<hr width="500" color="tomato"/>
				<h3>EMP 테이블 사원 상세내역</h3>
			<hr width="500" color="tomato"/>
			<br/><br/>
			<table border="1" cellspacing="0" width="350">
				<c:set var="dto" value="${cont }"/>
				<c:if test="${!empty dto }">
					<tr>
						<th>사원번호</th>
						<td>${dto.getEmpno() }</td>
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
						<td><fmt:formatNumber value="${dto.getSal() }" pattern="###,###,###.##"/></td>
					</tr>
					<tr>
						<th> 보너서,</th>
						<td><fmt:formatNumber value="${dto.getComm() }" pattern="###,###,###.##"/></td>
					</tr>
					<tr>
						<th>부서번호</th>
						<td>${dto.getDeptno() }</td>
					</tr>
					<tr>
						<th>입사일자</th>
						<td>${dto.getHiredate() }</td>
					</tr>
				</c:if>
				<c:if test="${empty dto }">
				<tr>
						<td colspan="2" align="center"><h3>검색된 레코드가 없습니다.</h3></td>
					</tr>
				</c:if>
			
				
				<tr>
					<td colspan="2" align="right">
						<input type="button" value="수정" onclick="location.href='emp_update.do?empno=${dto.getEmpno() }'"> 
						<input type="button" value="삭제" onclick="location.href='emp_delete.do?empno=${dto.getEmpno() }'"> 
						<input type="button" value="목ㄺ" onclick="location.href='emp_list.do'"> 
					</td>
				</tr>
			</table>
		
		</div>
</body>
</html>