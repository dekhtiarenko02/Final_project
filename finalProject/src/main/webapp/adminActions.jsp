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

        <div id="hiddenBlock">
        </div>
        <div class="adminActions">
        <button id="userListButton" class="listOfUsersButton" type="submit"><label><fmt:message key="user_list"/></label></button>
        <button id="changeUserButton" class="changingUserButton" type="submit"><label><fmt:message key="change_user"/></label></button>
        <button id="deleteBookButton" class="deletingBookButton" type="submit"><label><fmt:message key="delete_book"/></label></button>
        <button id="bookListButton" class="listOfBookButton" type="submit"><label><fmt:message key="book_list"/></label></button>
        <button id="changeBookButton" class="changingBookButton" type="submit"><label><fmt:message key="change_book"/></label></button>
        <form action="insertBook.jsp?id=${idVal}" method="post">
            <button id="insertBookButton" class="insertingBookButton" type="submit"><label><fmt:message key="insert_book"/></label></button>
        </form>
              <table id="tableOfUsers_Admin">
                     <tr>
                         <th>Id</th>
                         <th>Email</th>
                         <th>Name</th>
                         <th>Surname</th>
                         <th>Librarian</th>
                         <th>Admin</th>
                         <th>Blocked</th>
                         <th>Password</th>
                     </tr>
                     <c:forEach var="user" items="${userList}">
                     <tr>
                         <td>${user.getId()}</td>
                         <td>${user.email}</td>
                         <td>${user.name}</td>
                         <td>${user.surname}</td>
                         <td>${user.librarian}</td>
                         <td>${user.admin}</td>
                         <td>${user.blocked}</td>
                         <td>${user.password}</td>
                     </tr>
                     </c:forEach>
              </table>

            <table id="bookListTable">
                <tr>
                    <th>Id</th>
                    <th>Genre</th>
                    <th>Author</th>
                    <th>Name Of Book</th>
                    <th>Publisher</th>
                    <th>Year</th>
                    <th>Availability</th>
                    <th>Number Of Pages</th>
                    <th>Language</th>
                    <th>Is Order</th>
                </tr>
                <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.getId()}</td>
                    <td>${book.getGenre()}</td>
                    <td>${book.getAuthor()}</td>
                    <td>${book.getNameOfBook()}</td>
                    <td>${book.getPublisher()}</td>
                    <td>${book.getYear()}</td>
                    <td>${book.getAvailability()}</td>
                    <td>${book.getNumberOfPages()}</td>
                    <td>${book.getLanguage()}</td>
                    <td>${book.getIsOrder()}</td>
                </tr>
                </c:forEach>
                </table>

        </div>
        <div id="changeUserContainer">
        <form action="changeUser.jsp?id=${idVal}" method="post">
            <img class="avatar"  src="images/avatarR.png">
                   <div class="dws-input">
                       <input type = "text" name="user_id" placeholder="Enter User Id">
                   </div>
            <input class ="dws-submit" type="submit" value="Confirm">
            </form>
        </div>
        <div id="changeBookContainer">
        <form action="changeBook.jsp?id=${idVal}" method="post">
            <img class="avatar"  src="images/avatarR.png">
                   <div class="dws-input">
                       <input type = "text" name="book_id" placeholder="Enter Book Id">
                   </div>
            <input class ="dws-submit" type="submit" value="Confirm">
            </form>
        </div>
        <div id="deleteBookContainer">
        <form action="deleteBook.jsp?id=${idVal}" method="post">
            <img class="avatar"  src="images/avatarR.png">
              <div class="dws-input">
                  <input type = "text" name="book_id" placeholder="Enter Book Id">
              </div>
            <input class ="dws-submit" type="submit" value="Confirm">
            </form>
        </div>
        <script>
        document.getElementById('changeUserButton').onclick = function() {
          document.getElementById('changeUserContainer').style.display = "block";
          document.getElementById('hiddenBlock').style.display = "block";
          document.getElementById('tableOfUsers_Admin').style.display = "none";
          document.getElementById('bookListTable').style.display = "none";
          document.getElementById('changeBookContainer').style.display = "none";
          document.getElementById('insertBookContainer').style.display = "none";
          document.getElementById('deleteBookContainer').style.display = "none";
        }
        document.getElementById('userListButton').onclick = function() {
          document.getElementById('changeUserContainer').style.display = "none";
          document.getElementById('hiddenBlock').style.display = "none";
          document.getElementById('tableOfUsers_Admin').style.display = "block";
          document.getElementById('bookListTable').style.display = "none";
          document.getElementById('deleteBookContainer').style.display = "none";
          document.getElementById('changeBookContainer').style.display = "none";
          document.getElementById('insertBookContainer').style.display = "none";
        }
        document.getElementById('bookListButton').onclick = function() {
          document.getElementById('changeUserContainer').style.display = "none";
          document.getElementById('hiddenBlock').style.display = "none";
          document.getElementById('tableOfUsers_Admin').style.display = "none";
          document.getElementById('bookListTable').style.display = "block";
          document.getElementById('changeBookContainer').style.display = "none";
          document.getElementById('deleteBookContainer').style.display = "none";
          document.getElementById('insertBookContainer').style.display = "none";
        }
        document.getElementById('changeBookButton').onclick = function() {
          document.getElementById('changeUserContainer').style.display = "none";
          document.getElementById('hiddenBlock').style.display = "block";
          document.getElementById('tableOfUsers_Admin').style.display = "none";
          document.getElementById('bookListTable').style.display = "none";
          document.getElementById('changeBookContainer').style.display = "block";
          document.getElementById('deleteBookContainer').style.display = "none";
          document.getElementById('insertBookContainer').style.display = "none";
        }
        document.getElementById('deleteBookButton').onclick = function() {
          document.getElementById('changeUserContainer').style.display = "none";
          document.getElementById('hiddenBlock').style.display = "block";
          document.getElementById('deleteBookContainer').style.display = "block";
          document.getElementById('tableOfUsers_Admin').style.display = "none";
          document.getElementById('bookListTable').style.display = "none";
          document.getElementById('changeBookContainer').style.display = "none";
          document.getElementById('insertBookContainer').style.display = "none";
        }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>