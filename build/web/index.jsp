<%-- 
    Document   : index
    Created on : Nov 30, 2021, 12:26:36 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Page</title>
        <link rel="stylesheet" href="tailwind.css"/>
    </head>
    <body class="bg-gradient-to-r from-gray-900 to-gray-400 min-h-screen pt-12 md:pt-20 pb-6 px-2 md:px-0" style="font-family:'Lato',sans-serif;">
        <%
            if (session.getAttribute("username") != null) {
                session.invalidate();
            }
        %>
        <header class="max-w-lg mx-auto">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <h1 class="text-4xl font-bold text-white text-center">Vaccine Administration Tracker</h1>
            </a>
        </header>

        <main class="bg-white max-w-lg mx-auto p-8 md:p-12 my-10 rounded-lg shadow-2xl">
            <section>
                <h3 class="font-bold text-2xl text-gray-600">ADMIN LOGIN FORM</h3>
                <p class="text-gray-600 pt-2">Login to your account.</p>
            </section>

            <section class="mt-2">
                <form class="flex flex-col" method="POST" action="AdminLogin">
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="username">Admin Username</label>
                        <input type="text" id="username" name="username" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                    </div>
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="password">Admin Password</label>
                        <input type="password" id="password" name="password" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                    </div>
                    <button class="bg-gray-600 hover:bg-gray-900 text-white font-bold py-2 rounded shadow-lg hover:shadow-xl transition duration-200" type="submit">Login</button>
                    <div class="flex justify-end">
                        <a href="${pageContext.request.contextPath}/patientLogin.jsp" class="text-sm font-bold pt-4 text-gray-600 hover:text-gray-900 hover:underline mb-6">I am a patient.</a>
                    </div>
                </form>
            </section>
        </main>
        <div class="max-w-lg mx-auto text-center">
            <p class="text-white">Want to become an Admin? <a href="${pageContext.request.contextPath}/AdminRegistrationForm.jsp" class="font-bold hover:underline">Sign up</a>.</p>
        </div>
    </body>
</html>