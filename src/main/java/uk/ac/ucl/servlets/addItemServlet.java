package uk.ac.ucl.servlets;

import jdk.jshell.spi.ExecutionControl;
import uk.ac.ucl.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/item.html")
public class addItemServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.

        // Invoke the JSP page.
        Model model = ModelFactory.getModel();
        String showName = request.getParameter("showName");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        String path = request.getParameter("pathOfImage");
        String listName = request.getParameter("listToAddItem");
        String similarCategory = request.getParameter("similarCategory");
        model.addItemToList(listName,showName, description, url, path, similarCategory);
        model.writeToFile(model.getMotherList(), "./data/categoryAndShows.json");
        //ServletContext context = getServletContext();
        //RequestDispatcher dispatch = context.getRequestDispatcher("/viewList.html");
        //dispatch.forward(request, response);
        response.sendRedirect("/viewList.html");
    }
}