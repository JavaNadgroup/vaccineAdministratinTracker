<%-- 
    Document   : HealthCenter_to_db
    Created on : Dec 1, 2021, 8:34:47 PM
    Author     : Tusiime Allan
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
