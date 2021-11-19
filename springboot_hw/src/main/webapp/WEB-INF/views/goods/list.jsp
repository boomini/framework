<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<c:if test="${empty userinfo}">
	<script type="text/javascript">
		alert("로그인 후 이용 가능한 페이지입니다.");
		location.href = "${root}/goods/login";
		})
	</script>
</c:if>
<c:if test="${!empty userinfo}">
	
   <div class="content">
      <script type="text/javascript">				
      		var checkBoxArr=[];
          $(document).ready(function () {
            $("#mvRegisterBtn").click(function () {
              location.href = "goods/register";
            });
            $("#searchBtn").click(function(){
            	$("#searchform").attr("action", "/homework/mainsv").submit();
            })
            $("#deleteBtn").click(function(){
            	deleteClick();
            	console.log(checkBoxArr);
            	$("#deleteform").attr("action", "${root}/goods/delete").submit();
            })
            
            //회원 목록
			$.ajax({
				url:'${root}/goods/',  
				type:'GET',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				success:function(goods) {
					makeList(goods);
				},
				error:function(xhr, status, error){
					console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
				},
				statusCode: {
					500: function() {
						alert("서버에러.");
						// location.href = "/error/e500";
					},
					404: function() {
						alert("페이지없다.");
						// location.href = "/error/e404";
					}
				}	
          });
          });
          
          function deleteClick(){
        	  
        	  $("input:checkbox[name='delch']:checked").each(function(){
        		  checkBoxArr.push($(this).val());
        		  console.log(checkBoxArr);
        	  })
          }
          
          function makeList(goods) {
				$("#productlist").empty();
				$(goods).each(function(index, product) {
					console.log(product);
					let str=`
					<h2>check</h2>
						<table class="table table-active text-left" >
		                <tbody>
		                    <tr class="table-info">
		                    	<td colspan="2" class="table-danger"> 카테고리: ${'${product.cate}'}</td>
		                    	<td colspan="3" class="table-danger">
		                            <strong>${'${product.seq}'}. ${'${product.item_code}'}</strong>
		                        </td>                       
		                    </tr> 
		                    <tr class="table-info">
		                        <td class="text-right"> 상품이름: ${'${product.item_name}'}</td>
		                        <td class="text-right"> 상품가격: ${'${product.item_price}'}</td>
		                        <td class="text-right"> 상품회사: ${'${product.item_corp}'}</td>                       
		                    </tr> 
		                    <tr class="table-info">
		                        <td class="text-right" colspan="2" > 상품날짜: ${'${product.date}'}</td>
		                        <td class="text-right"> 상품상태: ${'${product.item_stat}'}</td>                        
		                    </tr>
		                    <tr>
								<td colspan="2">
									<ul>`
									var files=product.fileInfos
									$(files).each(function(index, file){
										console.log(file);
										str+=`<img src="${root}/img${'${file.file_path_org}'}">`
									});
							str+=`
									</ul>
								</td>
							</tr>
		                    <tr class="table-info">
		                        <td class="text-right" colspan="4"> 
		                        	<a href="${root}/goods/modify?seq=${'${product.seq}'}">수정</a>
									<input type="checkbox" name="delch" id="delch" value="${'${product.seq}'}">
		                        </td>                        
		                    </tr>
		                </tbody>
		            </table>
		            `;
					$("#productlist").append(str);
				});//each
          }
        </script>
        <div class="container text-center mt-3">
          <div class="col-lg-8 mx-auto">
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">상품목록</mark></h2>
            <div class="m-3 text-right">
              <button type="button" id="mvRegisterBtn" class="btn btn-link">상품등록</button>
            </div>
            
            
             <div class="m-3 text-right">
              <button type="button" id="deleteBtn" class="btn btn-link">선택항목삭제</button>
            </div>
           
		        <div class="search">
		          <form id="searchform" method="GET" action="">
		          <input type="hidden" name="act" id="act" value="list" />
		            	검색명 : <input type="text" name="search" id="search" size="40" />
		            <div class="priceSearch">
		              	가격 :
		              <input type="text" name="lprice" id="lprice" />~
		              <input type="text" name="rprice" id="rprice" />
		              <button id="searchBtn">검색</button>
		            </div>
		          </form>
		        </div>
		        <form id="deleteform" method="POST" action="">
	            	<div id="productlist">
			            
		            </div>
	            </form>
 
          </div>
        </div>
    </div>
    
  </body>
</html>
</c:if>