<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#mvIndex").click(function () {
                location.href = "${root}";
            });
        });
    </script>

    <div class="content container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <div class="jumbotron">
                <h1 class="text-danger">오류가 발생하였습니다.</h1>
                </p>
            </div>
        </div>
    </div>
</body>

</html>