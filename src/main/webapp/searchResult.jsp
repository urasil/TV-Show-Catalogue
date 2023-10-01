<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ImageProcessing" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>TV Series Catalogue</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search Result</h1>
  <%
    List<HashMap<String, Object>> allResults = (List<HashMap<String, Object>>) request.getAttribute("allResults");
    List<String> listNames = (List<String>) request.getAttribute("listNames");
    List<String> itemLists = (List<String>) request.getAttribute("itemLists");
    List<String> imgList = (List<String>) request.getAttribute("allBase64Images");
    if (allResults != null && !allResults.isEmpty()) {
  %>
  <ul>
    <u><b>TV Shows that contain the search string</b></u><br>
    <%
      int counter = 1;
      for(HashMap item : allResults) {
        if(item != null) {
          String path = (String) item.get("path");
          String showName = (String) item.get("showName");
          String description = (String) item.get("description");
          String imgType = path.split("\\.")[path.split("\\.").length-1];
          String listName = listNames.get(counter-1);
          String url = (String) item.get("url");
          url = "https://www." + url;
          String similarCategory = (String) item.get("similarCategory");
    %>
    <u><b>Item # <%=counter%></b></u>
    <li><b>Name of the show: </b><%=showName%></li>
    <li><b>Description of the show: </b><%=description%></li>
    <li><b>URL of the show: </b><a href=<%=url%>><%=url%></a></li>
    <li><b>Item belongs to category: </b><%=listName%></li>
    <li><b>Similar category to this TV show: </b><a href="/runSearchList.html?similarCategory=<%=similarCategory%>"><%=similarCategory%></a></li>
    <%
      if((imgType.equals("png") || imgType.equals("jpg")) && (imgList != null) && (imgList.get(counter -1) != null))
      {
    %><img src="data:image/<%=imgType%>;base64,<%=imgList.get(counter-1)%>"/>
    <br>
    <%}%>

    <% counter++;} else { %>
    <li><p>Item not found!</p></li>
    <% }
    }
    %>
  </ul>
  <% } else { %>
  <p>No TV shows matching the search criteria found!</p>
  <% } %>
  <%if (itemLists != null && !itemLists.isEmpty())
  {
    %><u><b>Categories that contain the search string</b></u><%
    for(String nameOfList : itemLists)
    {
      %><li><b>Link to category: </b><a href="/runSearchList.html?nameOfList=<%=nameOfList%>"><%=nameOfList%></a></li><br>

  <%
    }
  }
  else {
  %><p>No categories matching the search criteria found!</p><%
    }

  %>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>