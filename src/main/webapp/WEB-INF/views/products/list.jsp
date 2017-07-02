<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Cadastro de livros</title>
</head>
<body>
<table>
    <tr>
        <th>Título</th>
        <th>Valores</th>
    </tr>
    <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.title}</td>
            <td>
                <c:forEach items="${product.prices}" var="price">
                    [${price.value} - ${price.bookType}]
                </c:forEach>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
