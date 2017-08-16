<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
    <form:form   method="post" modelAttribute="client">
        <h2 class="form-signin-heading">Пожалуйста, введите Ваши данные</h2>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="firstName" path="firstName">Имя:</form:label>
                <div class="col-xs-9">
                  <form:input type="text" class="form-control" id="firstName" path="firstName" placeholder="Введите имя"/>
                </div>
            </label>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="lastName" path="lastName" >Фамилия:</form:label>
                <div class="col-xs-9">
                  <form:input type="text" class="form-control" id="lastName" path="lastName" placeholder="Введите фамилию"/>
                </div>
            </label>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="email" path="email" >Email:</form:label>
                <div class="col-xs-9">
                  <form:input type="text" class="form-control" id="email" path="email" placeholder="Введите email"/>
                </div>
            </label>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="password" path="password">Пароль:</form:label>
                <div class="col-xs-9">
                  <form:password class="form-control" id="password" path="password" placeholder="Введите пароль"/>
                </div>
            </label>
        </div>
        <div class="form-group">
            <form:label class="control-label col-xs-3" for="confirmPass" path="confirmPass" >Повтор пароля:</form:label>
                <div class="col-xs-9">
                  <form:password class="form-control" id="confirmPass" path="confirmPass" placeholder="Введите пароль еще раз"/>
                </div>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироваться</button>
        <a th:href="@{/login.jsp}" />
    </form:form>
</div>

</body>