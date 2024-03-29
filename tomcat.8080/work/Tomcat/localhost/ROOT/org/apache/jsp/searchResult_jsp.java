/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2023-03-30 11:43:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import uk.ac.ucl.model.ImageProcessing;
import java.util.HashMap;

public final class searchResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("uk.ac.ucl.model.ImageProcessing");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.HashMap");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/meta.jsp", out, false);
      out.write("\n");
      out.write("  <title>TV Series Catalogue</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("  <h1>Search Result</h1>\n");
      out.write("  ");

    List<HashMap<String, Object>> allResults = (List<HashMap<String, Object>>) request.getAttribute("allResults");
    List<String> listNames = (List<String>) request.getAttribute("listNames");
    List<String> itemLists = (List<String>) request.getAttribute("itemLists");
    List<String> imgList = (List<String>) request.getAttribute("allBase64Images");
    if (allResults != null && !allResults.isEmpty()) {
  
      out.write("\n");
      out.write("  <ul>\n");
      out.write("    <u><b>TV Shows that contain the search string</b></u><br>\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    <u><b>Item # ");
      out.print(counter);
      out.write("</b></u>\n");
      out.write("    <li><b>Name of the show: </b>");
      out.print(showName);
      out.write("</li>\n");
      out.write("    <li><b>Description of the show: </b>");
      out.print(description);
      out.write("</li>\n");
      out.write("    <li><b>URL of the show: </b><a href=");
      out.print(url);
      out.write('>');
      out.print(url);
      out.write("</a></li>\n");
      out.write("    <li><b>Item belongs to category: </b>");
      out.print(listName);
      out.write("</li>\n");
      out.write("    <li><b>Similar category to this TV show: </b><a href=\"/runSearchList.html?similarCategory=");
      out.print(similarCategory);
      out.write('"');
      out.write('>');
      out.print(similarCategory);
      out.write("</a></li>\n");
      out.write("    ");

      if((imgType.equals("png") || imgType.equals("jpg")) && (imgList != null) && (imgList.get(counter -1) != null))
      {
    
      out.write("<img src=\"data:image/");
      out.print(imgType);
      out.write(";base64,");
      out.print(imgList.get(counter-1));
      out.write("\"/>\n");
      out.write("    <br>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("\n");
      out.write("    ");
 counter++;} else { 
      out.write("\n");
      out.write("    <li><p>Item not found!</p></li>\n");
      out.write("    ");
 }
    }
    
      out.write("\n");
      out.write("  </ul>\n");
      out.write("  ");
 } else { 
      out.write("\n");
      out.write("  <p>No TV shows matching the search criteria found!.</p>\n");
      out.write("  ");
 } 
      out.write('\n');
      out.write(' ');
      out.write(' ');
if (itemLists != null && !itemLists.isEmpty())
  {
    
      out.write("<u><b>Categories that contain the search string</b></u>");

    for(String nameOfList : itemLists)
    {
      
      out.write("<li><b>Link to category: </b><a href=\"/runSearchList.html?nameOfList=");
      out.print(nameOfList);
      out.write('"');
      out.write('>');
      out.print(nameOfList);
      out.write("</a></li><br>\n");
      out.write("\n");
      out.write("  ");

    }
  }
  else {
  
      out.write("<p>No categories matching the search criteria found!</p>");

    }

  
      out.write("\n");
      out.write("</div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
