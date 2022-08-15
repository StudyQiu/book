<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示页面</title>
    <%--BootStrap美化界面--%>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表——————显示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <%--toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
            </div>
            <div class="col-md-8 column">
                <%--搜索/模糊查询--%>
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                    <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称...">
                    <input type="submit" value="搜索" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <%--把数据库数据遍历到前台--%>
                <tbody>
                    <c:forEach items="${list}" var="book">
                        <tr>
                            <c:if test="${book == null}">
                                <td>
                                    <span style="color: #ff0000; font-weight: bold">未找到相关数据</span>
                                </td>
                            </c:if>
                            <c:if test="${book != null}">
                                <td>${book.bookid}</td>
                                <td>${book.bookname}</td>
                                <td>${book.bookcounts}</td>
                                <td>${book.detail}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/toUpdateBook?bookid=${book.bookid}">修改</a>
                                    &nbsp;| &nbsp;
                                    <a href="${pageContext.request.contextPath}/book/delBookById?id=${book.bookid}">删除</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
