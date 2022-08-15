<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页面</title>
    <%--BootStrap美化界面--%>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <%--id隐藏域--%>
            <input type="hidden" name="bookid" value="${book.bookid}">
            <div class="form-group">
                <label>书籍名称:</label>
                <input type="text" name="bookname" class="form-control" value="${book.bookname}" required>
            </div>
            <div class="form-group">
                <label>书籍数量:</label>
                <input type="text" name="bookcounts" class="form-control" value="${book.bookcounts}" required>
            </div>
            <div class="form-group">
                <label>书籍描述:</label>
                <input type="text" name="detail" class="form-control" value="${book.detail}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>

</div>

</body>
</html>
