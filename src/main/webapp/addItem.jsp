<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Show Category</title>
</head>
<body>
<div class = "main">
    <h1>Add a new Category for TV Shows</h1>
    <%
        List<String> allCategoryNames = (List<String>) request.getAttribute("allCategoryNames");
    %>
    <form method = "POST" action="/item.html">
        <select name="listToAddItem">
            <%
                for(String categories : allCategoryNames)
                {
                    %>
            <option value="<%=categories%>"><%=categories%></option>

             <%}%>

        </select>

        Name of the show:
        <input type="text" name="showName" placeholder="Enter show name here"><br>
        <br>
        Description of the show:
        <input type="text" name="description" placeholder="Enter description of the show here"><br>
        <br>
        URL of the show:
        <input type="text" name="url" placeholder="Enter the url of the show here"><br>
        <br>
        A category that has TV Shows similar to this one:
        <input type="text" name="similarCategory" placeholder="Enter a similar category"><br>
        <br>
        Path of image:
        <input type="text" name="pathOfImage" placeholder="Path of the image for TV Show">
        <br>
        <input type="submit" value="Add">
    </form>
    <li>
        <a href="index.html">Back to Main Menu</a>
    </li>
    <br>
    <li>
        <a href="search.html">Search</a>
    </li>
</div>
</body>
</html>