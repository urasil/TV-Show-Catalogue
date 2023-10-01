<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit/Del Category</title>
</head>
<body>
<div class = "main">
    <h1>Edit or Delete an existing Category</h1>
    <%
        List<String> allCategoryNames = (List<String>) request.getAttribute("allCategoryNames");
    %>
    <form method = "POST" action="/editList.html">
        <select name="editList">
            <%
                for(String category : allCategoryNames)
                {
            %>
            <option value="<%=category%>"><%=category%></option>

            <%}%>
        </select>
        <br>
        <button type="submit" name="deleteButton">Delete Selected</button>
        <br>
        New Category Name:
        <input type="text" name="newCategory" placeholder="Enter category name here"><br>
        <br>
        <input type="submit" value="Edit">
    </form>
    </li>
    <li>
        <a href="index.html">Back to Main Menu</a>
    </li>
    <br>
    <li>
        <a href="addList.jsp">Add Category</a>
    </li>
    <br>
    <li>
        <a href="addItemServlet.html">Add TV Show </a>
    </li>
    <br>
    <li>
        <a href="search.html">Search</a>
    </li>
</div>
</body>
</html>