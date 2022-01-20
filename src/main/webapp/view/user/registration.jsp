<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
</head>
<body>
<div>
    <h1>Registration</h1>
    <form action="${pageContext.request.contextPath}/Controller?command=register" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><input type="text" name="surname"></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email"></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
