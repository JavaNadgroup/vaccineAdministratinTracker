<%-- 
    Document   : PatientRegForm
    Created on : Dec 5, 2021, 9:48:53 PM
    Author     : ogrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookings Form</title>
        <link rel="stylesheet" href="tailwind.css"/>
    </head>
    <body class="bg-gradient-to-r from-gray-900 to-gray-400 min-h-screen pt-12 md:pt-20 pb-6 px-2 md:px-0" style="font-family:'Lato',sans-serif;">
        <header class="max-w-lg mx-auto">
            <a href="#">
                <h1 class="text-4xl font-bold text-white text-center">Place Your Booking</h1>
            </a>
        </header>

        <main class="bg-white max-w-lg mx-auto p-8 md:p-12 my-10 rounded-lg shadow-2xl">
            <section>
                <h3 class="font-bold text-2xl text-gray-600">BOOKING INFORMATION</h3>
                <p class="text-gray-600 pt-2">Enter Your Preferences here.</p>
            </section>

            <section class="mt-2">
                <form class="flex flex-col" method="POST" action="VaccinationBooking">
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="nin">NIN</label>
                        <input type="text" id="nin" name="nin" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                    </div>
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="email">Email</label>
                        <input type="text" id="email" name="email" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                    </div>
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="name">name</label>
                        <input type="text" id="name"  name="name" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                    </div>
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="date">Preferred Date of Vaccination</label>
                        <input type="date" id="nin" name="date" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                    </div>
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="hospital">Preferred Health Center for Vaccination</label>
                        <select name="hospital" id="hospital" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                            <option value="" selected disabled>Choose Hospital</option>
                            <option value="mulago">mulago</option>
                            <option value="nsambya">nsambya</option>
                            <option value="kirudu">kirudu</option>
                            <option value="mengo">mengo</option>
                            <option value="novik">novik</option>
                        </select>
                    </div>
                    <div class="mb-6 pt-3 rounded bg-gray-200">
                        <label class="block text-gray-700 text-sm font-bold mb-2 ml-3" for="vaccine">Preferred Vaccine Type</label>
                        <select name="vaccine" id="vaccine" class="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-gray-600 transition duration-500 px-3 pb-3">
                            <option value="" selected disabled>Choose Vaccine Administered</option>
                            <option value="moderna">moderna</option>
                            <option value="pfizer">phizer</option>
                            <option value="johnson and johnson">Johnson and Johnson</option>
                        </select>
                    </div>
                    <button class="bg-gray-600 hover:bg-gray-900 text-white font-bold py-2 rounded shadow-lg hover:shadow-xl transition duration-200" type="submit">Book Now</button>
                </form>
            </section>
        </main>
    </body>
</html>

