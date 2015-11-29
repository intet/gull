<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--suppress HtmlFormInputWithoutLabel -->
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div align="center">
    <h3>Login with Username and Password</h3>

    <form:form id='formLogin' action='./login' method='POST'>
        <table>
            <tr>
                <td>username:</td>
                <td><input type='text' name='username' value='' autofocus></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input type='password' name='password'/></td>
            </tr>
            <tr>
                <td><input type='checkbox' name='remember-me'/></td>
                <td>remember-me</td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>