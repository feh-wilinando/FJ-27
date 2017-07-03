<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Cadastro de livros</title>
</head>
<body>

<c:url value="/products" var="url" />

<form:form action="${spring:mvcUrl('PC#save').build()}" commandName="product" method="post">
    <div>
        <label for="title">Título</label>
        <form:input path="title" id="title"/>
        <form:errors path="title"/>
    </div>
    <div>
        <label for="description">Descrição</label>
        <form:textarea rows="10" cols="20" path="description"
                  id="description"/>
        <form:errors path="description"/>
    </div>

    <div>
        <label for="numberOfPages">Número de páginas</label>
        <form:input type="text" path="numberOfPages"
               id="numberOfPages"/>
        <form:errors path="numberOfPages"/>
    </div>

    <div>
        <c:forEach items="${types}" var="bookType" varStatus="status">
            <div>
                <label for="price_${bookType}">${bookType}</label>
                <form:input path="prices[${status.index}].value"
                       id="price_${bookType}"/>
                <form:errors path="prices[${status.index}].value"/>
                <form:hidden path="prices[${status.index}].bookType" value="${bookType}"/>
            </div>
        </c:forEach>
    </div>

    <div>
        <input type="submit" value="Enviar">
    </div>
</form:form>
</body>
</html>