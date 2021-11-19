<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

  <style>
      div,
      h2 {
        text-align: center;
      }
      img {
        width: 100px;
        height: 100px;
        margin-top: 10px;
      }
      .in {
        float: left;
      }
      .main {
        text-align: center;
        padding-left: 40px;
        padding-right: 20px;
        padding-top: 20px;
        margin: auto;
        width: 350px;
        height: 150px;
      }
      .login {
        margin-bottom: 5px;
      }
      a {
        margin: 10px;
      }
      .a {
        margin-top: 10px;
      }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                    $("#loginform").attr("action", "${root}/goods/login").submit();
                }
            });
        });
    </script>
  </head>
  <body>
  <c:if test="${!empty msg}">
  	<script type="text/javascript">
  		alert("${msg}");
  	</script>
  </c:if>
    <div class="main">
      <div>
        <h4 class="login">로그인하세요</h4>
        <form id="loginform" method="post" action="">
        	<input type="hidden" name="act" id="act" value="login">
          <div class="login form-group" >id <input type="text" id="userid" name="userid"/></div>
          <div class="login form-group">pw <input type="text"  id="userpwd" name="userpwd"/></div>
          <div class="login form-group"><button id="loginBtn">LOGIN</button></div>
        </form>
   
      </div>
    </div>

  </body>
</html>
