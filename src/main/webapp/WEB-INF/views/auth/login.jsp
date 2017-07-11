<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
          prefix="sec" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc"%>
<cdc:page title="Listagem de Produtos">
<form:form servletRelativeAction="/login">
    <table>
        <tr>
            <td>Login:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'>
        </tr>
        <input name="submit" type="submit"
               value="Logar"/>
        </td>
    </table>
</form:form>
</cdc:page>