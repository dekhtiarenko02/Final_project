<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="res"/>
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
            <form action ="SearchServlet?id=${idVal}" method = "post">
                <div>
                <fmt:message key="search" var="search_var"/>
                    <input type="text" class="search" name="Search" placeholder="${search_var}">
                    <button class="search-submit" type="submit"><label><fmt:message key="confirm"/></label></button>
                </div>
            </form>
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
      <form action="MainPageServlet?id=${idVal}" method="post">
      <strong class="popular"><label><fmt:message key="popular"/></label></strong>
      <div class="mainPageAvailabilityLess">
           <c:forEach var="book" items="${bookListAvailabilityLess}" end="4">
           <div class="mainBook">
           <img class="mainBooksImg" src="${book.getUrlImg()}">
           	    <p class="mainInfoBook">${book.nameOfBook}</p>
           </div>
           </c:forEach>
      </div>
      <strong class="muchInStock"><label><fmt:message key="muchInStock"/></label></strong>
      <div class="mainPageAvailabilityMore">
            <c:forEach var="book" items="${bookListAvailabilityMore}" end="4">
            <div class="mainBook">
            <img class="mainBooksImg" src="${book.getUrlImg()}">
            	    <p class="mainInfoBook">${book.nameOfBook}</p>
            </div>
            </c:forEach>
            </div>
      </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>
