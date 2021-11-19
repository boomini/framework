<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
        $(document).ready(function () {
            $("#loginBtn").click(function () {
                if (!$("#userid").val()) {
                    alert("아이디 입력!!!");
                    return;
                } else if (!$("#userpwd").val()) {
                    alert("비밀번호 입력!!!");
                    return;
                } else {
                    $("#loginform").attr("action", "${root}/phone/login").submit();
                }
            });
        });
    </script>
</head>
<body>
<h4 class="login">로그인하세요</h4>
        <form id="loginform" method="post" action="">
        	<input type="hidden" name="act" id="act" value="login">
          <div class="login form-group" >id <input type="text" id="userid" name="userid"/></div>
          <div class="login form-group">pw <input type="text"  id="userpwd" name="userpwd"/></div>
          <div class="login form-group"><button id="loginBtn">LOGIN</button></div>
        </form>
</body>
</html>