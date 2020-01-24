<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
</head>
<body>

<%--
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
--%>

<h3>Create Product</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/createTask">
    <table border="0">
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="${task.id}" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" value="${task.description}" /></td>
        </tr>
<%--        <tr>
            <td>Executor Id</td>
            <td><input type="text" name="executor_id" value="${task.executorId}" /></td>
        </tr>--%>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="taskList">Cancel</a>
            </td>
        </tr>
    </table>
</form>


</body>
</html>