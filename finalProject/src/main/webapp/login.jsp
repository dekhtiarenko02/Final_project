<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/css/main.css"%></style>
        <meta charset="utf-8">
        <title>Log in</title>
        <link href="main.css" rel="stylesheet" type = "text/css">
    </head>
    <body>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="res"/>
        <div class = "header">
            <nav id="languageHeader">
              <a href="LanguageServlet?id=${idVal}&language=en"><img class="usaFlag" src="images/unitedStates.png"></a>
              <span class="stick"></span>
              <a href="LanguageServlet?id=${idVal}&language=ru" ><img class="rusFlag" src="images/russia.png"></a>
            </nav>
            <a href="MainPageServlet?id=${idVal}"><img class="logo" src="images/logotype.png" width="64"
                height="64"></a>
            <nav id="notHiddenLinks">
                <a class = "link" href="login.jsp"><label><fmt:message key="log_in"/></label></a>
                <span class="stick">|</span>
                <a class = "link" href="registrationPage.jsp"><label><fmt:message key="sign_up"/></label></a>
            </nav>
            <nav id="hiddenLinks">
                <a class = "link" href="ProfileServlet?id=${idVal}"><label><fmt:message key="profile"/></label></a>
                <span class="stick">|</span>
                <a class = "link changeOnClick" href="MainPageServlet?id=${idVal}"><label><fmt:message key="log_out"/></label></a>
            </nav>
      </div>
<div class="container2">
    <img class="avatar"  src="images/avatarR.png">
      <form action ="LogInServlet" method = "post">
            <div class="dws-input">
                <img class="reg_images" src="images/email.png">
                 <fmt:message key="email" var="email_var"/>
                <input type = "email" name = "Email" placeholder="${email_var}">
            </div>

            <div class="dws-input">
                 <img class="reg_images" src="images/password.png">
                 <fmt:message key="password" var="password_var"/>
                <input type="password" pattern="(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Za-z]).*$"
               placeholder="${password_var}"
               name="Password">
            </div>
            <button class="dws-submit changeOnClick" type="submit"><label><fmt:message key="confirm"/></label></button>
        </form>
    </div>
           <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>