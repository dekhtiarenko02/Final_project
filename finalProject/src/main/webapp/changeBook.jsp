<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="res"/>
    <%
    if(request.getParameter("book_id") != null){
        String idParam = request.getParameter("book_id");
        request.setAttribute("idBook", idParam);
    }
    else{
        request.setAttribute("idBook", request.getAttribute("book_id"));
    }
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
                 <a href="CatalogServlet?genre=Detective&id=${idVal}" class="books_catalog_link"><label><fmt:message key="detective"/></label></a>
                 <a href="CatalogServlet?genre=Fantasy&id=${idVal}" class="books_catalog_link"><label><fmt:message key="fantasy"/></label></a>
                 <a href="CatalogServlet?genre=Horror&id=${idVal}" class="books_catalog_link"><label><fmt:message key="horror"/></label></a>
                 <a href="CatalogServlet?genre=Romance&id=${idVal}" class="books_catalog_link"><label><fmt:message key="romance"/></label></a>
                 <a href="CatalogServlet?genre=Psychology&id=${idVal}" class="books_catalog_link"><label><fmt:message key="psychology"/></label></a>
             </nav>
            <div class="books_catalog_overlay"> </div>
        </div>
        <div class = "header">
            <nav id="languageHeader">
              <a href="LanguageServlet?id=${idVal}&language=en"><img class="usaFlag" src="images/unitedStates.png"></a>
              <span class="stick"></span>
              <a href="LanguageServlet?id=${idVal}&language=ru" ><img class="rusFlag" src="images/russia.png"></a>
            </nav>
                <a href="MainPageServlet?id=${idVal}"><img class="logo2" src="images/logotype.png" width="64"
                   height="64">
                </a>
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
        <div id="hiddenBlock">
        </div>
        <form action="ChangeBookServlet?id=${idVal}&book_id=${idBook}" method="post">
        <div id="changeBook">
                  <div class="dws-input-change">
                  <fmt:message key="genre" var="genre_var"/>
                      <input class="input-change" type = "text" name="Genre" placeholder="${genre_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="authorA" var="author_var"/>
                    <input class="input-change" type = "text" name="Author" placeholder="${author_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="nameOfBookN" var="nameOfBook_var"/>
                    <input class="input-change" type = "text" name="NameOfBook" placeholder="${nameOfBook_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="publisherP" var="publisher_var"/>
                    <input class="input-change" type = "text" name="Publisher" placeholder="${publisher_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="yearY" var="year_var"/>
                    <input class="input-change" type = "text" name="Year" placeholder="${year_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="availability" var="availability_var"/>
                    <input class="input-change" type = "text" name="Availability" placeholder="${availability_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="numberOfPages" var="numberOfPages_var"/>
                    <input class="input-change" type = "text" name="NumberOfPages" placeholder="${numberOfPages_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="language" var="language_var"/>
                    <input class="input-change" type = "text" name="Language" placeholder="${language_var}">
                  </div>
                  <div class="dws-input-change">
                  <fmt:message key="isOrder" var="isOrder_var"/>
                    <input class="input-change" type = "text" name="IsOrder" placeholder="${isOrder_var} (true/false)">
                  </div>
                  <button class="dws-submit" type="submit"><label><fmt:message key="confirm"/></label></button>
        </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>