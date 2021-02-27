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
     <div class="books_catalog">
                <a href = "#" class="books_catalog_button">
                    <span class="books_catalog_lines"> </span>
                </a>
            <%
                String genreParam = request.getParameter("genre");
                String idParam = request.getParameter("id");
                request.setAttribute("idVal", idParam);
            %>
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
                <input type="text" class="search" name="Search" placeholder="Search">
                <input class ="search-submit" type="submit" value="Confirm">
            </div>
        </form>
                <a href="MainPageServlet?id=${idVal}"><img class="logo2" src="images/logotype.png" width="64"
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
        <div class="catalogBook">
             <c:forEach var="book" items="${bookList}" end="1">
             <div class="bookStyle">
                <div class="titleBook">
                    <p class="indent">Genre: ${book.getGenre()}</p>
				    <p class="indent">${book.getAuthor()}.</p>
                </div>
                <img align="left" src=${book.getUrlImg()} class="bookIMG">
                <div class="infoBook">
                        <span>Author: ${book.getAuthor()}.</span><br>
                        <span>Name: <strong>${book.getNameOfBook()}.</strong></span><br>
                        <span>Publisher: </span>${book.getPublisher()}.<br>
                        <span>Year: </span>${book.getYear()}.<br>
                        <span>Availability: </span>
                        <c:if test="${book.getAvailability() >= 1}">
                            ${book.getAvailability()}.<br>
                        </c:if>
                        <c:if test="${book.getAvailability() <= 0}">
                            Out of stock.<br>
                        </c:if>
                        <span>Number of pages: </span>${book.getNumberOfPages()}.<br>
					    <span>Language:</span> ${book.getLanguage()}.<br>
            </div>
            <div class="plotBook">
                <p>${book.getPlot()}</p>
        </div>
        <form action="OrderServlet?id=${idVal}" method="post">
            <c:if test="${book.getAvailability() <= 0}">
                <button class="order-book" type="submit" name="orderButton" value="${book.getNameOfBook()}"><label><fmt:message key="order_book"/></label></button>
            </c:if>
        </form>

        <form action="ArrangeServlet?id=${idVal}" method="post">
            <c:if test="${book.getAvailability() >= 1}">
                <button class="arrange-book" type="submit" name="arrangeButton" value="${book.getNameOfBook()}"><label><fmt:message key="arrange_book"/></label></button>
            </c:if>
        </form>
        <form action="ReturnServlet?id=${idVal}" method="post">
                <button class="return-book" type="submit" name="returnButton" value="${book.getNameOfBook()}"><label><fmt:message key="return_book"/></label></button>
        </form>
        </div>
            </c:forEach>
            <div class="pagination">
                <c:forEach var="pages" items="${pageList}">
                    <a href="CatalogServlet?genre=${genre}&id=${idVal}&page=${pages}">${pages}</a>
                </c:forEach>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>