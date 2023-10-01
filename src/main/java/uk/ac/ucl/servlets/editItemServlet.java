package uk.ac.ucl.servlets;

import org.apache.catalina.connector.Response;
import uk.ac.ucl.model.Item;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.MotherList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editItem.html")
public class editItemServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.

        // Invoke the JSP page.
        Model model = ModelFactory.getModel();
        String oldName = request.getParameter("editItem");
        Item item = model.searchItem(oldName);
        if(request.getParameter("deleteButton") != null)
        {
            model.deleteItem(item);
        }
        else
        {
            String showName = request.getParameter("showName");
            String description = request.getParameter("description");
            String url = request.getParameter("url");
            String path = request.getParameter("path");
            String similarCategory = request.getParameter("similarCategory");
            model.editItem(item,showName, description, url, path, similarCategory);
        }
        model.writeToFile(model.getMotherList(), "./data/categoryAndShows.json");
        ServletContext context = getServletContext();
        //RequestDispatcher dispatch = context.getRequestDispatcher("/viewList.html");
        //dispatch.forward(request, response);
        response.sendRedirect("/viewList.html");
    }

}