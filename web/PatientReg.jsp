<%-- 
    Document   : PatientReg
    Created on : Dec 6, 2021, 1:19:05 AM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/patient_to_db.tld" prefix="vaccination" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Registration Confirmation</title>
    </head>
    <body>
        <%
            String nin = request.getParameter("nin");
            String name = request.getParameter("name");
            String  hospital = request.getParameter("hospital");
            String date = request.getParameter("date");
            String batch_number = request.getParameter("batch_number");
            String vaccine = request.getParameter("vaccine");
        %>
        
        <vaccination:insert table="patients" nin="${nin}" name="${name}" hospital="${hospital}" date="${date}" batch_number="${batch_number}" vaccine="${vaccine}" />
        
    </body>
</html>
