package uk.ac.ucl.servlets;

import org.apache.catalina.connector.Response;
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

@WebServlet("/addCategory.html")
public class addListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.

        // Invoke the JSP page.
        String category = request.getParameter("category");
        Model model = ModelFactory.getModel();
        model.createList(category);
        model.writeToFile(model.getMotherList(), "./data/categoryAndShows.json");
        ServletContext context = getServletContext();
        //RequestDispatcher dispatch = context.getRequestDispatcher("/viewList.html");
        //dispatch.forward(request, response);
        response.sendRedirect("/viewList.html");
    }

}
