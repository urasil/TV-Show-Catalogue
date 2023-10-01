package uk.ac.ucl.servlets;

import uk.ac.ucl.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/runsearch.html")
public class SearchServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // Use the model to do the search and put the results into the request object sent to the
    // Java Server Page used to display the results.
      Model model = ModelFactory.getModel();
      List<HashMap<String, Object>> allResults = model.search(request.getParameter("searchstring"));
      List<String> itemLists = model.searchList(request.getParameter("searchstring"));
      List<String> listsThatItemsBelong = new ArrayList<>();
      List<HashMap<String, Object>> listOfSearchResults = new ArrayList<>();
      for(HashMap item : allResults)
      {
        listsThatItemsBelong.add(model.getListNameFromItem((String) item.get("showName")));
        listOfSearchResults.add(item);
      }
      List<String> imgList = model.readAllImages(listOfSearchResults);
      request.setAttribute("allBase64Images", imgList);
      request.setAttribute("listNames", listsThatItemsBelong);
      request.setAttribute("allResults", allResults);
      request.setAttribute("itemLists", itemLists);

      // Invoke the JSP page.
      ServletContext context = getServletContext();
      RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
      dispatch.forward(request, response);

  }
}
