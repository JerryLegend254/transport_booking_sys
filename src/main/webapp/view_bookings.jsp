<%@ page import="com.psv.dao.BookingDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.psv.model.Booking" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/07/2023
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="flex flex-col justify-center">
    <h2 class="text-3xl text-center font-bold uppercase">Bookings</h2>

    <%
        BookingDao bookingDao = new BookingDao();
        List<Booking> bookings =  bookingDao.getBookings();

    %>

    <table class="border-2 border-black w-5/6 self-center mt-4">
        <thead class="space-x-2 border-b-2 border-black">
        <th class="border-r-2 border-black">Booking ID</th>
        <th class="border-r-2 border-black"class="border-r-2 border-black">Passenger name</th>
        <th class="border-r-2 border-black">Vehicle plate</th>
        <th>Booking Date</th>

        </thead>
        <tbody>

        <%for (Booking b: bookings){%>
        <tr>
            <td class="border-r-2 border-b border-black text-center"><%=b.getBook_id()%></td>
            <td class="border-r-2 border-b border-black text-center"><%=b.getPassenger_name()%></td>
            <td class="border-r-2 border-b border-black text-center"><%=b.getVeh_regno()%></td>
            <td class="border-r-2 border-b border-black text-center"><%=b.getBooking_date()%></td>

        </tr>
        <%}%>

        </tbody>
    </table>
</div>