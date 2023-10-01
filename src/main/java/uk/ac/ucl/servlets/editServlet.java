package uk.ac.ucl.servlets;

import org.apache.catalina.connector.Response;
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
import java.util.List;

@WebServlet("/editServlet.html")
public class editServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.

        // Invoke the JSP page.
        Model model = ModelFactory.getModel();
        if(!model.getMotherList().isEmpty())
        {
            List<Item> allItems = model.getAllItems();
            List<String> allCategoryNames = model.allCategoryNames();
            List<String> allShowNames = new ArrayList<>();
            for(Item item : allItems)
            {
                allShowNames.add(item.getShowName());
            }
            request.setAttribute("allShowNames", allShowNames);
            request.setAttribute("allCategoryNames", allCategoryNames);
            String type = request.getParameter("type");
            if (type.equals("tv_show")) {
                // Dispatch to edit/delete TV show JSP page
                if(!allItems.isEmpty())
                {
                    ServletContext context = getServletContext();
                    RequestDispatcher dispatch = context.getRequestDispatcher("/editDeleteItem.jsp");
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
                    out.println("<h1>Add an item first to edit it!</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    out.close();
                }
            } else if (type.equals("category")) {
                // Dispatch to edit/delete category JSP page
                ServletContext context = getServletContext();
                RequestDispatcher dispatch = context.getRequestDispatcher("/editDeleteList.jsp");
                dispatch.forward(request, response);
            }
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
            out.println("<h1>No TV show or Category exists to edit!</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

}