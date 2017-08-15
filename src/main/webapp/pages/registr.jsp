<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/signin.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container" style="width: 300px;">
    <form action="/" th:object="${client}"method="post">
        <h2 class="form-registration-heading">Пожалуйста, введите Ваши данные</h2>
        <div>
                <label th:text="#{label.client.firstName}">first</label>
                <input th:field="*{firstName}"/>
                <p th:each="error: ${#fields.errors('firstName')}"
                  th:text="${error}">Validation error</p>
        </div>
        <div>
                <label th:text="#{label.client.lastName}">last</label>
                <input th:field="*{lastName}"/>
                <p th:each="error : ${#fields.errors('lastName')}"
                  th:text="${error}">Validation error</p>
        </div>
        <div>
                <label th:text="#{label.client.email}">email</label>
                <input type="email" th:field="*{email}"/>
                <p th:each="error : ${#fields.errors('email')}"
                  th:text="${error}">Validation error</p>
        </div>
        <div>
                <label th:text="#{label.client.password}">password</label>
                <input type="password" th:field="*{password}"/>
                <p th:each="error : ${#fields.errors('password')}"
                  th:text="${error}">Validation error</p>
        </div>
        <div>
                <label th:text="#{label.client.confirmPass}">confirm</label>
                <input type="password" th:field="*{confirmPass}"/>
        </div>
        <button type="submit" th:text="#{label.form.submit}">submit</button>
        <a th:href="@{/login.jsp}" th:text="#{label.form.loginLink}">login</a>
    </form>
</div>

</body>