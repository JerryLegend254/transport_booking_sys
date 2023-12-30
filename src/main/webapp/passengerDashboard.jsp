<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/07/2023
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Online Booking System</title>
  <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="flex justify-between items-center bg-blue-600">
  <div class="m-5"><span class="text-2xl font-bold font-serif text-white">Booking</span><span class="text-2xl font-bold font-serif text-black">Space.</span></div>
  <div></div>
  <div class="flex flex-row items-center">
    <p class="mr-5 font-bold text-white"><%= session.getAttribute("currUser")%></p>
    <a href="/passengerSO" class="bg-blue-900 py-2 px-4 font-bold text-white rounded-lg mr-5 font-serif">SIGN OUT</a>
  </div>

</div>
<div class="flex">
  <div class="w-1/5 bg-blue-600 h-screen space-y-1 flex flex-col">
    <a class="px-4 text-white font-sm py-2 border-b-2 border-t-2" onclick="loadContent('bookTrip')" href="#">Book Trip</a>
  </div>
  <div class="w-full" id="dynamicContent"></div>
  <script>
    function loadContent(action) {
      // Use AJAX to fetch the content from the server (servlet)
      $.ajax({
        url: 'ContentServlet',
        type: 'POST',
        data: { action: action },
        success: function(data) {
          // Update the div with the received content
          $('#dynamicContent').html(data);
        }
      });
    }
  </script>

</div>

</body>
</html>
