<%-- 
    Document   : adminLogin
    Created on : Dec 3, 2021, 8:34:10 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/AdminLogin.tld" prefix="vaccination"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
        <vaccination:select table="admins" username="${username}" password="${password}"/>
    </body>
</html>
