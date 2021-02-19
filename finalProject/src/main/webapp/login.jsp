<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/css/main.css"%></style>
        <meta charset="utf-8">
        <title>Log in</title>
        <link href="main.css" rel="stylesheet" type = "text/css">
    </head>
    <body>
        <div class = "header">
            <a href="index.jsp"><img class="logo" src="images/logotype.png" width="64"
                height="64"></a>
           <nav id="notHiddenLinks">
               <a class = "link" href="login.jsp">Log in</a>
               <span class="stick">|</span>
               <a class = "link" href="registrationPage.jsp">Sign Up</a>
           </nav>
           <nav id="hiddenLinks">
               <a class = "link" href="ProfileServlet">Profile</a>
               <span class="stick">|</span>
               <a class = "link changeOnClick" href="index.jsp">Log out</a>
           </nav>
      </div>
<div class="container2">
    <img class="avatar"  src="images/avatarR.png">
      <form action ="LogInServlet" method = "post">

            <div class="dws-input">
                <img class="reg_images" src="images/email.png">
                <input type = "email" name = "Email" placeholder="Your Email">
            </div>

            <div class="dws-input">
                 <img class="reg_images" src="images/password.png">
                <input type="password" pattern="(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Za-z]).*$"
               placeholder="Your Password"
               name="Password">
            </div>
                <input class ="dws-submit changeOnClick" type="submit" value = "Confirm">
        </form>
    </div>
           <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>