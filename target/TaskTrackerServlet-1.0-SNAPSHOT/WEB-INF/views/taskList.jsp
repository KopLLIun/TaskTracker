<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

<%--<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>--%>

<h3>Task List</h3>

<%--<p style="color: red;">${errorString}</p>--%>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Description</th>
        <th>Executor Id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${taskList}" var="task" >
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.executorId}</td>
            <td>
                <a href="editTask?id=${task.id}">Edit</a>
            </td>
            <td>
                <a href="deleteTask?id=${task.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createTask" >Create Task</a>
<a href="taskListJson">Json representation</a>
</body>
</html>