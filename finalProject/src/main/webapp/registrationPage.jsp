<%@ page contentType="text/html;charset=cp1251" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/css/main.css"%></style>
        <meta charset="cp1251">
        <title>Registration Page</title>
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
        <div class="container">
            <img class="avatar"  src="images/avatarR.png">
                <form action ="RegisterServlet" method = "post">
                      <div class="dws-input">
                          <img class="reg_images" src="images/email.png">
                          <input type = "email" name = "Email" placeholder="Your Email">
                      </div>

                      <div class="dws-input">
                          <img class="reg_images" src="images/name.png">
                          <input type = "text" name = "Name" placeholder="Your Name">
                      </div>

                      <div class="dws-input">
                          <img class="reg_images" src="images/surname.png">
                        <input type = "text" name = "Surname" placeholder="Your Surname">
                      </div>
                      <div class="dws-input">
                           <img class="reg_images" src="images/password.png">
                          <input type="password" pattern="(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Za-z]).*$"
                         placeholder="Your Password(Min 6 Chars)"
                         name="Password">
                      </div>
                          <input class ="dws-submit" type="submit" value = "Confirm">
                </form>
        </div>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>