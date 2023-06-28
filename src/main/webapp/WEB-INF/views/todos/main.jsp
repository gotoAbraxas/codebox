<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>
<body>

<%@ include file="header.jsp" %>

<h1><%=(String) request.getAttribute("name")%> 환영합니다.</h1>

<%@ include file="todos.jsp"%>
<%@ include file="todolist.jsp"%>
<form method="get" action="/main">
    <input type="text" name="keyword">
    <input type="submit" value="찾기">
</form>
</body>
</html>