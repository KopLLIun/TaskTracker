<%--
  Created by IntelliJ IDEA.
  User: nikita.radevich
  Date: 9.01.20
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Name: <%= request.getParameter("username")%></p>
<p>Age: <%= request.getParameter("userage")%></p>
<p>Gender: <%= request.getParameter("gender")%></p>
<p>Country: <%= request.getParameter("country")%></p>
<h4>Selected courses</h4>
<ul>
    <%
        String[] courses = request.getParameterValues("courses");
        for(String course: courses){
            out.println("<li>" + course + "</li>");
        }
    %>
</ul>
</body>
</html>
