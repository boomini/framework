<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

   <div class="content">
<head>
    <meta charset="UTF-8">
    <title>SSAFY - 글작성</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        mark.sky {
            background: linear-gradient(to top, #54fff9 20%, transparent 30%);
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#registerBtn").click(function () {
                if (!$("#item_code").val()) {
                    alert("상품코드 입력!!!!");
                    return;
                } else if (!$("#item_name").val()) {
                    alert("상품이름 입력!!!!");
                    return;
                } else if (!$("#item_price").val()) {
                    alert("상품가격 입력!!!!");
                    return;
                }else if (!$("#item_corp").val()) {
                    alert("회사 입력!!!!");
                    return;
                }else if (!$("#item_stat").attr('value')) {
                	console.log($("#item_stat").attr('value'))
                    alert("판매 상태 선택!!!!");
                    return;
                }else if (!$("#cate_seq option:selected").val()) {
                	console.log($("#cate_seq option:selected").val())
                    alert("카테고리 선택!!!!");
                    return;
                }
                else {
                    $("#writeform").attr("action", "${root}/goods/register").submit();
                }
            });
        });
    </script>
   <link rel="stylesheet" href="${root}/css/header.css" />
</head>
<body>
    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">상품등록</mark></h2>
            <form id="writeform" class="text-left mb-3" method="post" enctype="multipart/form-data" action="">
 				<div class="form-group">
                    <label for="cate_seq">카테고리:</label>
                    <select id="cate_seq" name="cate_seq" class="form-control">
	            		<option value="1"> 헤어
	            	</select>
                </div>
                <div class="form-group">
                    <label for="item_code">상품코드:</label>
                    <input type="text" class="form-control" id="item_code" name="item_code" placeholder="상품코드...">
                </div>
                <div class="form-group">
                    <label for="item_name">상품명:</label>
                    <input type="text" class="form-control" id="item_name" name="item_name" placeholder="상품명...">
                </div>
                <div class="form-group">
                    <label for="item_price">판매가:</label>
                    <input type="text" class="form-control" id="item_price" name="item_price" placeholder="가격...">
                </div>
                <div class="form-group">
                    <label for="item_corp">공급사:</label>
                    <input type="text" class="form-control" id="item_corp" name="item_corp" placeholder="공급사...">
                </div>
                <div class="form-group">
                    <label for="item_stat">판매상태:</label>
                    <input type="radio" name="item_stat" id="item_stat" value="Y"/>판매함
                    <input type="radio" name="item_stat" id="item_stat" value="N"/>판매불가
                </div>
                <div class="form-group" align="left">
					<label for="upfile">파일:</label>
					<input type="file" class="form-control-file border" name="upfile" multiple="multiple">
				</div>
                <div class="text-center">
                    <button type="button" id="registerBtn" class="btn btn-outline-primary">등록</button>
                    <button type="reset" class="btn btn-outline-danger">취소</button>
                </div>
            </form>
        </div>
    </div>
    </div>
    </div>
    
  </body>
</html>