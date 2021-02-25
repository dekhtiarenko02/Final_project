 <%@ page contentType="text/html;charset=cp1251" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
     <head>
         <style><%@include file="/WEB-INF/css/main.css"%></style>
         <meta charset="cp1251">
         <title>Web Library</title>
         <link href="main.css" rel="stylesheet" type = "text/css">
         <link rel="preconnect" href="https://fonts.gstatic.com">
         <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap" rel="stylesheet">
     </head>
     <body>

     <%
     if(request.getParameter("id") != null){
         String idParam = request.getParameter("id");
         request.setAttribute("idVal", idParam);
     }
     else{
         request.setAttribute("idVal", request.getAttribute("id"));
     }
     %>
         <div class="books_catalog">
             <a href = "#" class="books_catalog_button">
                 <span class="books_catalog_lines"> </span>
             </a>
             <nav class="books_catalog_nav">
                 <a href="CatalogServlet?genre=Detective&id=${idVal}" class="books_catalog_link">Detective</a>
                 <a href="CatalogServlet?genre=Fantasy&id=${idVal}" class="books_catalog_link">Fantasy</a>
                 <a href="CatalogServlet?genre=Horror&id=${idVal}" class="books_catalog_link">Horror</a>
                 <a href="CatalogServlet?genre=Romance&id=${idVal}" class="books_catalog_link">Romance</a>
                 <a href="CatalogServlet?genre=Psychology&id=${idVal}" class="books_catalog_link">Psychology</a>
             </nav>
             <div class="books_catalog_overlay"> </div>
         </div>

         <div class = "header">
                 <a href="MainPageServlet?id=${idVal}"><img class="logo2" src="images/logotype.png" width="64"
                    height="64">
                 </a>
             <nav id="notHiddenLinks">
                 <a class = "link" href="login.jsp">Log in</a>
                 <span class="stick">|</span>
                 <a class = "link" href="registrationPage.jsp">Sign Up</a>
             </nav>
             <nav id="hiddenLinks">
                 <a class = "link" href="ProfileServlet?id=${idVal}">Profile</a>
                 <span class="stick">|</span>
                 <a class = "link changeOnClick" href="MainPageServlet?id=${idVal}">Log out</a>
             </nav>
         </div>
         <div class="editContainer">
         <img class="avatar"  src="images/avatarR.png">
            <form action="EditProfileServlet?id=${idVal}" method="post">
                  <div class="dws-input">
                      <img class="reg_images" src="images/name.png">
                      <input type = "text" name = "Name" placeholder="Your new name">
                  </div>
                  <div class="dws-input">
                      <img class="reg_images" src="images/surname.png">
                    <input type = "text" name = "Surname" placeholder="Your new surname">
                  </div>
                  <div class="dws-input">
                       <img class="reg_images" src="images/password.png">
                      <input type="password" pattern="(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Za-z]).*$"
                     placeholder="Your new password"
                     name="Password">
                  </div>
                  <input class ="dws-submit" type="submit" value = "Confirm">
            </form>
         </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>