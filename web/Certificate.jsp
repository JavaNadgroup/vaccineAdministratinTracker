<%-- 
    Document   : Certificate
    Created on : Dec 8, 2021, 7:02:07 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/certificate.tld" prefix="vaccination"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Certificate</title>
        <link rel="stylesheet" href="tailwind.css"/>
    </head>
    <body class="bg-gradient-to-r from-gray-50 to-gray-60 min-h-screen pt-12 md:pt-20 pb-6 px-2 md:px-0">
    <%   
  
        String name=(String)session.getAttribute("name");    //Getting Session Attribute
        String nin=(String)session.getAttribute("nin");
    %> 
    
    <main class="bg-white max-w-lg mx-auto p-8 md:p-12 my-10 rounded-lg shadow-2xl">
        <section>
            <h3 class="font-bold text-2xl text-gray-600">CERTIFICATE OF VACCINATION</h3>
            <p class="text-gray-600 pt-2">This is to certify that the below person has been vaccinated.</p>
        </section>

        <vaccination:select table="patients" name="${name}" nin="${nin}" />
    </main>
    </body>
</html>
