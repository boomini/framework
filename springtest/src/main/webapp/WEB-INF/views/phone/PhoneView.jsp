<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>핸드폰 관리</title>
<script type="text/javascript">
        
    </script>
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
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰보기</b></td>
		  </tr>
	  </table>  
	  <br>
	  <!-- num,model,price,vcode -->
	  <!-- write Form  -->
	  <form id="writeform" method="post" action="">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${phone.num}  
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모 델 명</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${phone.mode }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${phone.price }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제 조 사</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${phone.vendor}
			</td>
		  </tr>		  
	  </table>

	  <br>
	  
	 <a href="${root}/phone/list">핸드폰 목록</a><br />

</body>

</html>