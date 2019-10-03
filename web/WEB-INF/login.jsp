<%-- 
    Document   : login
    Created on : Sep 26, 2019, 4:35:57 PM
    Author     : 738634
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
        <label>User Name:</label>
        <input type="text" name="user_name" value="" /><br>
        <label>Password:</label>
        <input type="password" name="user_password" value="" /><br>
        <input type="submit" value="Login" />
        ${message}
        </form>
    </body>
</html>
