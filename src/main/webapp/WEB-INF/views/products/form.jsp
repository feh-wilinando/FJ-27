<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags"
          prefix="sec" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc" %>
<cdc:page title="Listagem de Produtos">
    <c:url value="/products" var="url"/>

    <form:form action="${spring:mvcUrl('PC#save').build()}" commandName="product" method="post"
               enctype="multipart/form-data">
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
            <label for="releaseDate">Data de Lançamento</label>
            <form:input type="date" id="releaseDate" path="releaseDate"/>
            <form:errors path="releaseDate"/>
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
            <label for="summary">Sumário do Livro</label>
            <input type="file" id="summary" name="summary">
            <form:errors path="summaryPath"/>
        </div>

        <div>
            <input type="submit" value="Enviar">
        </div>
    </form:form>

</cdc:page>