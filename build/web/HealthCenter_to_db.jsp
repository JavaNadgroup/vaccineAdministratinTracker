<%-- 
    Document   : HealthCenter_to_db
    Created on : Dec 5, 2021, 10:59:15 AM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/HealthCenter_to_db.tld" prefix="vaccination" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Health Center add success</title>
    </head>
    <body>
        <%
            String hospital_name = request.getParameter("hospital_name");
        %>
        <vaccination:insert table="hospitals" hospital_name="${hospital_name}"/>
    </body>
</html>
