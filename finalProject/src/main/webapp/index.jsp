<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/css/main.css"%></style>
        <meta charset="cp1251">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Web Library</title>
        <link href="main.css" rel="stylesheet" type = "text/css">
    </head>
    <body>
    <%
        String genreParam = request.getParameter("genre");
        request.setAttribute("genreVar",genreParam);
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
            <form action ="SearchServlet" method = "post">
                <div>
                    <input type="text" class="search" name="Search" placeholder="Search">
                    <input class ="search-submit" type="submit" value="Confirm">
                </div>
            </form>
            <nav id="notHiddenLinks">
                <a class = "link" href="login.jsp">Log in</a>
                <span class="stick">|</span>
                <a class = "link" href="registrationPage.jsp">Sign Up</a>
            </nav>
            <nav id="hiddenLinks">
                <a class = "link" href="ProfileServlet?id=${idVal}">Profile</a>
                <span class="stick">|</span>
                <a class = "link changeOnClick" href="index.jsp?id=${idVal}">Log out</a>
            </nav>
      </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>
