<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td>
			모델번호
			</td>
			<td>
			모델이름
			</td>
			<td>
			가격
			</td>
			<td>
			제조사명
			</td>
			<td>
			삭제
			</td>
		  </tr>
		  <c:forEach var="phone" items="${phoneList}">
			  <tr>
					<td>
					<a href="${root}/phone/view?num=${phone.num}">${phone.num}</a><br />				
					</td>
					<td>
					${phone.mode}
					</td>
					<td>
					${phone.price}
					</td>
					<td>
					${phone.vendor}
					</td>
					<td>
					 <a href="${root}/phone/delete?num=${phone.num}">삭제</a><br />
					</td>
		  	</tr>
			</c:forEach>
	  </table>
	  <a href="${root}/phone/register">핸드폰등록</a><br />
	  <a href="${root}/">메인</a><br />
</body>
</html>