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
        <link rel="stylesheet" href="tailwind.css"/>
    </head>
    <body class="bg-gradient-to-r from-gray-900 to-gray-400 min-h-screen pt-12 md:pt-20 pb-6 px-2 md:px-0" style="font-family:'Lato',sans-serif;">
        <%
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
        <%@taglib uri="/WEB-INF/tlds/AdminReg.tld" prefix="vacination"%>
        <vacination:insert table="admins" email="${email}" username="${username}" password="${password}"/>
        <div class="p-10 flex flex-col mx-auto items-center space-y-3">
            <div class="bg-green-100 p-5 w-full sm:w-1/2 rounded">
              <div class="flex justify-between">
                <div class="flex space-x-3">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="flex-none fill-current text-green-500 h-4 w-4">
                    <path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1.25 16.518l-4.5-4.319 1.396-1.435 3.078 2.937 6.105-6.218 1.421 1.409-7.5 7.626z" /></svg>
                </div>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="flex-none fill-current text-green-600 h-3 w-3">
                  <path d="M23.954 21.03l-9.184-9.095 9.092-9.174-2.832-2.807-9.09 9.179-9.176-9.088-2.81 2.81 9.186 9.105-9.095 9.184 2.81 2.81 9.112-9.192 9.18 9.1z" /></svg>
              </div>
              <div class="flex-1 leading-tight text-sm text-green-700 font-medium">
                  <br>
                  Admin Account has been created successfully....
              <br><br>
                Click button to go back to login page
                <a class="flex sm:inline-flex justify-center items-center bg-green-500 hover:bg-green-600 active:bg-green-700 focus-visible:ring ring-green-300 text-white font-semibold text-center rounded-md outline-none transition duration-100 px-2 py-1 ml-2" href="${pageContext.request.contextPath}/index.jsp">
                    Here
                </a>
              </div>
            </div> 
        </div>      
    </body>
</html>
