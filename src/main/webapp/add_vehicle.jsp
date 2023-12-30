<%@ page import="com.psv.dao.Bus_StopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.psv.model.BusStop" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/07/2023
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w-full">
    <div class="flex items-center justify-center w-full">
        <div class="w-full">
            <h2 class="border-b-2 py-2 text-center text-2xl font-bold shadow-sm"><span class="text-blue-500">ADD</span> <span class="text-red-500">VEHICLE</span></h2>
            <%

            Bus_StopDao busStopDao = new Bus_StopDao();
            List<String> busStops = busStopDao.getBusStops();


            %>
            <form method="post" action="/vehicleReg" class="flex justify-center pt-8">
                <div class="mx-5 my-2 grid w-full space-y-3">
                    <input class="rounded-md border-2 px-2 py-1 w-full" type="text" id="regNo" name="regNo" placeholder="Vehicle Plate" />
                    <input class="rounded-md border-2 px-2 py-1 w-full" type="number" id="capacity" name="capacity" placeholder="Vehicle Capacity" />
                    <div class="w-full">
                        <label for="bus_stops">Select the bus stops that apply:</label>
                        <div class="border-2 my-2 rounded-lg">
                        <select class="w-full" name="bus_stops" id="bus_stops" multiple>
                            <%for (String stop: busStops){%>
                                <option value="<%=stop%>"><%=stop%></option>
                            <%}%>
                        </select>
                        </div>
                    </div>
                    <input class="rounded-md bg-blue-600 py-2 text-xl text-white hover:bg-blue-400" type="submit" id="btn" value="Add vehicle" />
                </div>
            </form>
        </div>
    </div>
</div>
