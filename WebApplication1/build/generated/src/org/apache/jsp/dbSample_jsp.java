package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dbSample_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  // MySQL 8.0 以上版本 - JDBC 驅動名及資料庫 URL
       static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
       static final String DB_URL = "jdbc:mysql://localhost:3306/my_test_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 
     // 資料庫的使用者名稱與密碼，需要根據自己的設定
       static final String USER = "root";
       static final String PASS = "root";

 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");

      
try{
  Class.forName(JDBC_DRIVER); 
  Connection con= DriverManager.getConnection(DB_URL , USER , PASS);

  Statement st = con.createStatement();

  String sql= "SELECT * FROM product";
  ResultSet rs = st.executeQuery(sql);

  while (rs.next()) {
    out.println("ID： " + rs.getInt(1)); 
    out.println("產品名稱：" + rs.getString(2));
    out.println("產品描述：" + rs.getString(3));
    out.println("產品價格：" + rs.getInt(4)+"<br/>");
  }
  System.out.println("TEST");
  


  rs.close();
  st.close();
  con.close();
}catch(Exception e){out.println("資料庫連節發生問題："+e.toString() );}


      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
