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

        <div class="profile">
            <img class="profileImg" src="images/profileU.png">
            <div class="personalData">
            <form action ="editProfile.jsp?id=${idVal}" method = "post">
                <button class="editProfileButton" type="submit"><label><fmt:message key="edit_profile"/></label></button>
            </form>
                <p><label><fmt:message key="name"/></label>: ${user.name} <p>
                <p><label><fmt:message key="surname"/></label>: ${user.surname}</p>
                <p><label><fmt:message key="email"/></label>: ${user.email}</p>
                <c:if test="${user.getAdmin() == true}">
                    <p class="admin"><label><fmt:message key="admin"/></label>: true</p>
                    <form action ="AdminActionsServlet?id=${idVal}" method = "post">
                        <button class="adminActionsButton" type="submit"><label><fmt:message key="admin_actions"/></label></button>
                    </form>
                </c:if>
                <c:if test="${user.getLibrarian() == true}">
                    <p class="librarian"><label><fmt:message key="librarian"/></label>: true</p>
                    <form action ="LibrarianActionsServlet?id=${idVal}" method = "post">
                        <button class="librarianActionsButton" type="submit"><label><fmt:message key="librarian_actions"/></label></button>
                    </form>
                </c:if>
                <c:if test="${date != null}">
                    <p><label><fmt:message key="return_date"/></label>: ${date}</p>
                    <p><label><fmt:message key="penalty"/></label>: ${penalty} $</p>
                    <p><label><fmt:message key="books"/></label>:
                    <c:forEach var="book" items="${bookList}">
                    <c:if test="${book != bookList.get(bookList.size() - 1)}">
                        "${book}",
                    </c:if>
                    </c:forEach>
                    "${bookList.get(bookList.size()- 1)}"
                </c:if>
                </p>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>
