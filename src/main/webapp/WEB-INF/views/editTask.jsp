<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>

<h3>Edit Product</h3>

    <form method="POST" action="${pageContext.request.contextPath}/editTask">
        <input type="hidden" name="id" value="${task.id}" />
        <table border="0">
            <tr>
                <td>Id</td>
                <td style="color:red;">${task.id}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" value="${task.description}" /></td>
            </tr>
            <tr>
<%--                <td>Executor Id</td>--%>
<%--                <td><input type="text" name="executor_id" value="${task.executorId}" /></td>--%>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/taskList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>