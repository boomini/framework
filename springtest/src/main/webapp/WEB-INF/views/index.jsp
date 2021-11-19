<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
      <h2>메인페이지</h2>
      <a href="${root}/phone/register">핸드폰등록</a><br />
	  <a href="${root}/phone/list">핸드폰 목록</a><br />
	  <c:if test="${empty userinfo}">
	  <a href="${root}/phone/login">로그인</a><br />
    	</c:if>
    	<c:if test="${!empty userinfo}">
	  <a href="${root}/phone/logout">로그아웃</a><br />
    	</c:if>
    </div>
  </body>
</html>
