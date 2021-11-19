<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SSAFY GOODS</title>
    <link
          rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        />
        <style>
          mark.sky {
            background: linear-gradient(to top, #54fff9 20%, transparent 30%);
          }
          .priceSearch {
	        margin-top: 20px;
	        margin-bottom: 20px;
	      }
	      #searchBtn {
	        margin-left: 20px;
	      }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${root}/css/header.css" />
  </head>
  <body>
    <div class="header">
      <div class="nav">
        <a href="" id="logo">SSAFY </a> 
        <div class="login-area">
        <c:if test="${empty userinfo}">
	          <a href="${root}/goods/login" class="menu-item" id="login">로그인</a>
		</c:if>
		<c:if test="${!empty userinfo}">
	          <a href="${root}/goods/logout" class="menu-item" id="login">로그아웃</a>
		</c:if>
        </div>
      </div>
    </div>
    <div class="center">
        <div class="left">
            <div class="menu">
                <ul id="menu">
                    <li><a href="${root}/" class="menu-item" id="">Main</a></li>
                    <li><a href="${root}/goods/list" class="menu-item" id="">상품리스트</a></li>
                    <li><a href="${root}/goods/register" class="menu-item" id="">상품등록</a></li>
                </ul>
            </div>
        </div>
