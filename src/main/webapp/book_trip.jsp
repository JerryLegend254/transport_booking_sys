<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.psv.dao.Bus_StopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.psv.dao.TripDao" %>
<%@ page import="com.psv.model.Vehicle" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/07/2023
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w-full">
    <div class="flex items-center justify-center">
        <div class="w-full">
            <h2 class="border-b-2 py-2 text-center text-2xl font-bold shadow-sm"><span class="text-blue-500">BOOK</span> <span class="text-red-500">TRIP</span></h2>
            <%

                Bus_StopDao busStopDao = new Bus_StopDao();
                List<String> busStops = busStopDao.getBusStops();


            %>
            <form method="post" action="/checkAvailVehicles" class="flex justify-center pt-8">
                <div class="mx-5 my-2 grid w-full space-y-3">
                    <div class="flex items-center justify-center w-[50%]">
                        <label for="stop">Bus Stops: </label>
                        <select class="bg-gray-500 py-1 px-2 text-white rounded-lg mx-4" name="bus_stops" id="stop">
                            <%for (String stop: busStops){%>
                            <option value="<%=stop%>"><%=stop%></option>
                            <%}%>
                        </select>
                        <input class="rounded-lg bg-blue-600 px-4 py-1 text-sm font-bold text-white" type="submit" value="Confirm" />
                    </div>
                </div>
            </form>


            <form method="post" action="/bookTrip" class="flex justify-center">
                <div class="flex flex-col w-1/3">
                    <div class="flex flex-col items-center justify-center w-full">
                        <label class="block" for="stops">Available Vehicles for your trip: </label>
                        <select class="w-full text-white bg-gray-500 py-2 px-2 rounded-lg mb-2" name="vehicles" id="stops">
                            <c:forEach items="${availableVehicles}" var="v">
                                <option value="${v.getBookingNo()}">${v.getRegNo()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <input class="rounded-md bg-blue-600 py-2 text-xl text-white hover:bg-blue-400" type="submit" id="btn" value="Book Trip" />
                </div>
            </form>
        </div>
    </div>
</div>
