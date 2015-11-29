<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--suppress HtmlFormInputWithoutLabel -->
<html>
<head>
    <title>Login Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <!--suppress HtmlUnknownTarget -->
    <script src="js/login.js"></script>
    <!--suppress HtmlUnknownTarget -->
    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<div align="center">

    <div id="tabs" class="tab-centered">
        <ul>
            <li><a href="#tabs-1">Sign in</a></li>
            <li><a href="#tabs-2">Create user</a></li>
        </ul>
        <div id="tabs-1">
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
        <div id="tabs-2">
            <h3>Create user</h3>

            <form:form id='formCreate' action='./createUser' method='POST'>
                <table>
                    <tr>
                        <td>username:</td>
                        <td><input type='text' name='username' value=''></td>
                    </tr>
                    <tr>
                        <td>password:</td>
                        <td><input type='password' name='password'/></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>

    </div>
</div>
</body>
</html>