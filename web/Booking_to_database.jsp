<%-- 
    Document   : Booking_to_database
    Created on : Dec 6, 2021, 7:52:00 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/Bookings_to_database.tld" prefix="vaccination" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Successful</title>
    </head>
    <body>
        <%
            String nin = request.getParameter("nin");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String date = request.getParameter("date");
            String  hospital = request.getParameter("hospital");
            String vaccine = request.getParameter("vaccine");
        %>
        
        <vaccination:insert table="bookings" nin="${nin}" name="${name}" email="${email}" date="${date}" hospital="${hospital}" vaccine="${vaccine}" />
    </body>
</html>
