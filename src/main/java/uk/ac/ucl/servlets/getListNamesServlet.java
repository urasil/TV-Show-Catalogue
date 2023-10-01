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
import java.util.List;

@WebServlet("/addItemServlet.html")
public class getListNamesServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.

        // Invoke the JSP page.
        Model model = ModelFactory.getModel();
        if(!model.getMotherList().isEmpty())
        {
            List<String> allCategoryNames = model.allCategoryNames();
            request.setAttribute("allCategoryNames", allCategoryNames);
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/addItem.jsp");
            dispatch.forward(request, response);
        }
        else
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Page Not Found</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>A category needs to be added to start adding TV Shows!</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}