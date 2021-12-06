<%-- 
    Document   : PatientAuth
    Created on : Dec 6, 2021, 4:49:39 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/PatientAuth.tld" prefix="vaccination" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Logged in</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String nin = request.getParameter("nin");
            
            session.setAttribute("name", name);//setting the session
        %>
        <vaccination:select table="patients" name="${name}" nin="${nin}"/>
    </body>
</html>
