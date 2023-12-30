<%@ page import="com.psv.dao.VehicleDao" %>
<%@ page import="com.psv.model.Vehicle" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/07/2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w-full">
    <div class="flex items-center justify-center w-full">
        <div class="w-full">
            <h2 class="border-b-2 py-2 text-center text-2xl font-bold shadow-sm"><span class="text-blue-500">SCHEDULE</span> <span class="text-red-500">TRIP</span></h2>


            <%

                VehicleDao vehicleDao = new VehicleDao();
                List<Vehicle> availVehicles = vehicleDao.getAvailableVehicles();
            %>
            <form method="post" action="/scheduleTrip" class="flex justify-center pt-8">
                <div class="mx-5 my-2 grid w-full space-y-3">
                    <div class="flex justify-center w-full">
                        <label for="vehicles">Vehicle: </label>
                        <select name="vehicle" id="vehicles">
                            <%for (Vehicle v: availVehicles){%>
                            <option value="<%=v.getRegNo()%>"><%=v.getRegNo()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="flex items-center justify-center space-x-3 w-full">
                        <input type="checkbox" id="status" value="complete" name="isComplete"/>
                        <label for="status">Complete</label>
                    </div>

                    <input class="rounded-md bg-blue-600 py-2 text-xl text-white hover:bg-blue-400" type="submit" id="btn" value="Schedule Trip" />
                </div>
            </form>
        </div>
    </div>
</div>
