<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17/07/2023
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="templates/header.jsp"%>
<div class="content">

    <h2 class="text-center text-5xl font-bold border-b-2 shadow-sm py-2"><span class="text-blue-500">REGISTER</span> <span class="text-red-500">HERE</span></h2>

    <div class="flex justify-center align-center">
    <p class="text-center px-4 py-2 w-1/3 mt-2 self-center rounded-lg font-bold">${errors}</p>
    </div>
    <form method="post" action="/passengerReg" class="flex justify-center pt-8">
        <div class="grid mx-5 my-2 w-[432px] space-y-3">
            <div class="space-x-6">
                <input class="py-1 px-2 border-2 rounded-md" type="text" id="fName" name="fName" placeholder="First Name"/>
                <input class="py-1 px-2 border-2 rounded-md" type="text" id="lName" name="lName" placeholder="Last Name"/>
            </div>
            <input class="py-1 px-2 border-2 rounded-md" type="email" id="email" name="email" placeholder="Email"/>
            <input class="py-1 px-2 border-2 rounded-md" type="password" id="pass" name="pass" placeholder="Password"/>
            <input class="py-1 px-2 border-2 rounded-md" type="password" id="confPass" name="confPass" placeholder="Confirm Password"/>
            <input class="bg-blue-600 rounded-md py-2 text-xl text-white hover:bg-blue-400" type="submit" id="btn" value="Register">
            <p>Already Have an Account? <a href="/passengerSignIn">Sign In</a></p>
        </div>
    </form>



</div>
</body>
</html>
