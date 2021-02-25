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
        <div class="librarianActions">
        <button id="userListButton" class="listOfUsersButton" type="submit">User list</button>
        <button id="subscriptionButton" class="subscriptionOfUserButton" type="submit">Subscription</button>
        <button id="subscriptionBookButton" class="subscriptionBookOfUserButton" type="submit">Subscription book</button>
        <button id="bookListButton" class="bookListButton" type="submit">Book list</button>
        <div id="tables">
            <table id="tableOfUsers">
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
        <table id="subscriptionTable">
            <tr>
                <th>Id</th>
                <th>Penalty</th>
                <th>User Id</th>
            </tr>
            <c:forEach var="subscription" items="${subscriptionList}">
            <tr>
                <td>${subscription.getId()}</td>
                <td>${subscription.getPenalty()}</td>
                <td>${subscription.getUser_id()}</td>
            </tr>
            </c:forEach>
            </table>
            <table id="subscriptionBookTable">
            <tr>
                <th>Id</th>
                <th>Date Of Purchase</th>
                <th>Subscription Id</th>
                <th>Book Id</th>
            </tr>
            <c:forEach var="subscriptionBook" items="${subscriptionBookList}">
            <tr>
                <td>${subscriptionBook.getId()}</td>
                <td>${subscriptionBook.getDateOfPurchase()}</td>
                <td>${subscriptionBook.getSubscription_id()}</td>
                <td>${subscriptionBook.getBook_id()}</td>
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
        </div>
        <script>
        document.getElementById('userListButton').onclick = function() {
          document.getElementById('tableOfUsers').style.display = "block";
          document.getElementById('subscriptionTable').style.display = "none";
          document.getElementById('subscriptionBookTable').style.display = "none";
          document.getElementById('bookListTable').style.display = "none";
        }
        document.getElementById('subscriptionButton').onclick = function() {
          document.getElementById('tableOfUsers').style.display = "none";
          document.getElementById('subscriptionTable').style.display = "block";
          document.getElementById('subscriptionBookTable').style.display = "none";
          document.getElementById('bookListTable').style.display = "none";
        }
        document.getElementById('bookListButton').onclick = function() {
          document.getElementById('tableOfUsers').style.display = "none";
          document.getElementById('subscriptionTable').style.display = "none";
          document.getElementById('subscriptionBookTable').style.display = "none";
          document.getElementById('bookListTable').style.display = "block";
        }
        document.getElementById('subscriptionBookButton').onclick = function() {
          document.getElementById('tableOfUsers').style.display = "none";
          document.getElementById('subscriptionTable').style.display = "none";
          document.getElementById('subscriptionBookTable').style.display = "none";
          document.getElementById('bookListTable').style.display = "none";
          document.getElementById('subscriptionBookTable').style.display = "block";
        }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    </body>
</html>