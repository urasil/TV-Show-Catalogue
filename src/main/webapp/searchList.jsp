<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%@ page import="uk.ac.ucl.model.ImageProcessing" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>TV Series Catalogue</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <%List<String> imgList = (List<String>) request.getAttribute("allBase64Images");
    String categoryName = (String) request.getAttribute("listName");
    if(categoryName!=null && categoryName !="")
    {
      ArrayList<HashMap<String, Object>> allItems = (ArrayList<HashMap<String, Object>>) request.getAttribute("result");
  %>
  <h1>Contents of <%=categoryName%></h1>
  <ul>
  <%  int counter = 1;
      int index = 0;
      for(HashMap<String, Object> item : allItems)
      {
        String showName = String.valueOf(item.get("showName"));
        String description = String.valueOf(item.get("description"));
        String url = String.valueOf(item.get("url"));
        String similarCategory = String.valueOf(item.get("similarCategory"));
        url = "https://www." + url;
        String path = String.valueOf(item.get("path"));
        String imgType = path.split("\\.")[path.split("\\.").length-1];
  %>
    <li><b>Item # <%=counter%></b></li>
    <li><b>Name of the show: </b><%=showName%></li>
    <li><b>Description of the show: </b><%=description%></li>
    <li><a href=<%=url%>><%=url%></a><br></li>
    <li><b>Similar category to this TV show: </b><a href="/runSearchList.html?similarCategory=<%=similarCategory%>"><%=similarCategory%></a></li><br>
    <%
      if((imgType.equals("png") || imgType.equals("jpg")) && (imgList != null) && (imgList.get(index) != null))
      {
    %><img src="data:image/<%=imgType%>;base64,<%=imgList.get(index)%>"/><br><br>
    <%}%>

    <%index++;
      counter++;}%>
    <%
      }else
    {%>
    <p><b>List not found!</b></p>
    <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>