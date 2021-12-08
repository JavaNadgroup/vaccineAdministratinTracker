<%-- 
    Document   : EmailResponse
    Created on : Dec 8, 2021, 2:14:15 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/EmailResponse.tld" prefix="vaccination" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email</title>
        <link rel="stylesheet" href="tailwind.css"/>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
        %>
        <vaccination:select table="messages" email="${email}" />
    </body>
</html>
