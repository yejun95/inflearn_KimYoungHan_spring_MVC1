<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    상대경로이기 때문에 제일 마지막 url이 save로 바뀐다.--%>
<%--    /servlet-mvc/members/new-form => /servlet-mvc/members/save--%>
    <form action="save" method="post">
        username: <input type="text" name="username"/>
        age:      <input type="text" name="age"/>
        <button type="submit">전송</button>
    </form>
</body>
</html>
