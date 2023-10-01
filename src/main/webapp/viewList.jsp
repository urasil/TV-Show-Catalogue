<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="uk.ac.ucl.model.ImageProcessing" %>
<%@ page import="java.awt.*" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Displaying All Categories</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Your saved categories: </h2>
  <ul>
    <%
      List<String> images = (List<String>) request.getAttribute("allBase64Images");
      List<ArrayList<HashMap<String, Object>>> allItems = (List<ArrayList<HashMap<String, Object>>>) request.getAttribute("allItems");
      ArrayList<String> allCategories = (ArrayList<String>) request.getAttribute("allCategoryNames");
      String item = "";
      if(allCategories != null)
      {
        int index = 0;
        for (int i = 0; i < allCategories.size(); i++)
        {
          %><u></u><b><%=allCategories.get(i)%></b></u><br><br><%
          int counter = 1;
          if(allItems.get(i) != null)
          {
            List<String> similarCategories = new ArrayList<>();
            for(HashMap showDetails : allItems.get(i))
            {
                String showName = String.valueOf(showDetails.get("showName"));
                String description = String.valueOf(showDetails.get("description"));
                String url = String.valueOf(showDetails.get("url"));
                String similarCategory = String.valueOf(showDetails.get("similarCategory"));
                similarCategories.add(similarCategory);
                url = "https://www." + url;
                String path = String.valueOf(showDetails.get("path"));

    %>
      <b>Item # <%=counter%></b><br>
    <li>Name of the show: <%=showName%></li><br>
      <li>Description of the show: <%=description%></li><br>
      <a href=<%=url%>><%=url%></a><br><br>
      <li>Similar category to this TV show: <a href="/runSearchList.html?similarCategory=<%=similarCategory%>"><%=similarCategory%></a></li><br>

      <%
                String imgType = path.split("\\.")[path.split("\\.").length-1];
                if(imgType.equals("png") || imgType.equals("jpg"))
                {
                  %><img src="data:image/<%=imgType%>;base64,<%=images.get(index)%>"/><br><br>
              <%}%>

        <%counter++;
            index++;
            }request.setAttribute("similarCategories", similarCategories);
        %>
      <%}
      }
    }%>
    <br>
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

  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
