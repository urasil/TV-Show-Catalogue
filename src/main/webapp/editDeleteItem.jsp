<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edit/Del TV Show</title>
</head>
<body>
<div class = "main">
  <h1>Edit or Delete an existing TV Show</h1>
  <%
    List<String> allShowNames = (List<String>) request.getAttribute("allShowNames");
  %>
  <form method = "POST" action="/editItem.html">
    <select name="editItem">
      <%
        for(String showName : allShowNames)
        {
      %>
      <option value="<%=showName%>"><%=showName%></option>

      <%}%>
    </select>
      <br>
      <button type="submit" name="deleteButton">Delete Selected</button>
      <br>
      New Name of the show:
      <input type="text" name="showName" placeholder="Enter show name here"><br>
      <br>
      New Description of the show:
      <input type="text" name="description" placeholder="Enter description of the show here"><br>
      <br>
      New URL of the show:
      <input type="text" name="url" placeholder="Enter the url of the show here"><br>
      <br>
      A category that has TV Shows similar to this one:
      <input type="text" name="similarCategory" placeholder="Enter a similar category"><br>
      <br>
      New path of the image of the show:
      <input type="text" name="path" placeholder="Enter path of image here"><br>
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