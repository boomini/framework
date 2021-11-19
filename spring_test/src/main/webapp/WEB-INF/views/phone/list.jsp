<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>핸드폰 관리</title>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 목록 조회</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td align=center>모델번호</td> 
			<td align=center>모델이름</td> 
			<td align=center>가격</td> 
			<td align=center>제조사</td> 
			<td align=center>비고</td> 
		  </tr>	  
	  
	  	<c:forEach var="phone" items="${phones }">
			<tr>
				<td align=center>${phone.num }</td> 
				<td align=center>
				<a href="${root}/detail?num=${phone.num}">${phone.model }</td> 
				<td align=center>${phone.price }</td> 
				<td align=center>${phone.vendor }</td> 
				<td align=center>
					<a href="${root}/delete?num=${phone.num}">삭제</a>
				</td> 
			  </tr>	 
		  </c:forEach>
		 </table>
	  <br>
	  
</table>

</body>

</html>