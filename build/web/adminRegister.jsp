<%-- 
    Document   : adminRegister.jsp
    Created on : Nov 30, 2021, 3:15:25 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
        <%@taglib uri="/WEB-INF/tlds/AdminReg.tld" prefix="vacination"%>
        <vacination:insert table="admins" email="${email}" username="${username}" password="${password}"/>
    </body>
</html>
