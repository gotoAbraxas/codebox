<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-29
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
  <form action="/user/update" method="post">
    <input type="text" name = "password" placeholder=" 새 비밀번호를 입력해주세요.">
    <input type="text" name = "name" placeholder="새 이름을 입력해주세요.">
    <input type="submit">
  </form>
  <a href="/back">back</a>
</div>


</body>
</html>
