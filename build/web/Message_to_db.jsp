<%-- 
    Document   : Message_to_db
    Created on : Dec 7, 2021, 6:39:54 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/message_to_db.tld" prefix="vaccination" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message Success</title>
    </head>
    <body>
        <%
            String reciever = request.getParameter("reciever");
            String sender = request.getParameter("sender");
            String message = request.getParameter("message");
        %>
        <vaccination:insert_update table="messages" reciever="${reciever}" sender="${sender}" message="${message}"/>
    </body>
</html>
