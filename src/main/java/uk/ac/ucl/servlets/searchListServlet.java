package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ItemList;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

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

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/runSearchList.html")
public class searchListServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.
        Model model = ModelFactory.getModel();
        String similarCategory = (String) request.getParameter("similarCategory");
        String nameOfList = (String) request.getParameter("nameOfList");
        ItemList lst = model.getListFromListName(similarCategory);
        List<String> allImagesSimilarCategory = model.readAllImagesInList(similarCategory);
        List<String> allImagesNameOfList = model.readAllImagesInList(nameOfList);
        if(similarCategory == null)
        {
            similarCategory = "null";
        }

        if(!similarCategory.equals("null"))
        {
            if(lst != null) {
                request.setAttribute("allBase64Images", allImagesSimilarCategory);
                request.setAttribute("listName", similarCategory); //String
                request.setAttribute("result", model.viewItemsInList(lst)); //ArrayList<HashMap<String, Object>>

                // Invoke the JSP page.
                ServletContext context = getServletContext();
                RequestDispatcher dispatch = context.getRequestDispatcher("/searchList.jsp");
                dispatch.forward(request, response);
            }
            else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Page Not Found</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Category doesn't exist in the catalogue yet</h1>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }
        }
        else if(nameOfList != null)
        {
            if(model.getListFromListName(nameOfList) != null)
            {
                request.setAttribute("allBase64Images", allImagesNameOfList);
                request.setAttribute("listName", nameOfList);
                request.setAttribute("result", model.viewItemsInList(model.getListFromListName(nameOfList)));
                ServletContext context = getServletContext();
                RequestDispatcher dispatch = context.getRequestDispatcher("/searchList.jsp");
                dispatch.forward(request,response);
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
                out.println("<h1>Category doesn't exists in this catalogue yet!</h1>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }

        }
        else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Page Not Found</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>This item doesn't have a similar category set</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}