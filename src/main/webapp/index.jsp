<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/07/2023
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Transport Booking System</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class=" h-screen flex justify-center">
    <div class="flex flex-col justify-center items-center space-y-4">
        <h1 class="text-5xl font-bold font-serif">BOOKING SPACE.</h1>
        <p class="text-2xl font-semibold">Travel in Style</p>
        <div class="flex space-x-10 justify-center">
            <a class="bg-blue-600 text-white font-bold py-2 px-4 rounded-lg" href="/passengerSignIn">Passenger Sign In</a>
            <a class="bg-blue-600 text-white font-bold py-2 px-4 rounded-lg"class="bg-blue-600 text-white font-bold py-2 px-4 rounded-lg" href="/adminSignIn">Admin Sign In</a>
        </div>
    </div>
</div>
</body>
</html>
