/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-11-12 13:39:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("    <title>Login</title>\r\n");
      out.write("\r\n");
      out.write("    <meta\r\n");
      out.write("            content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\"\r\n");
      out.write("            name=\"viewport\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/ionicons/css/ionicons.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/adminLTE/css/AdminLTE.css\">\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/iCheck/square/blue.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"hold-transition login-page\">\r\n");
      out.write("<div class=\"login-box\">\r\n");
      out.write("    <div class=\"login-logo\">\r\n");
      out.write("        <a href=\"all-admin-index.html\"><b>ITCAST</b>后台管理系统</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.login-logo -->\r\n");
      out.write("    <div class=\"login-box-body\">\r\n");
      out.write("        <p class=\"login-box-msg\">登录系统</p>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login.do\" method=\"post\">\r\n");
      out.write("            <div class=\"form-group has-feedback\">\r\n");
      out.write("                <input type=\"text\" name=\"username\" class=\"form-control\"\r\n");
      out.write("                       placeholder=\"用户名\"> <span\r\n");
      out.write("                    class=\"glyphicon glyphicon-envelope form-control-feedback\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group has-feedback\">\r\n");
      out.write("                <input type=\"password\" name=\"password\" class=\"form-control\"\r\n");
      out.write("                       placeholder=\"密码\"> <span\r\n");
      out.write("                    class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xs-8\">\r\n");
      out.write("                    <div class=\"checkbox icheck\">\r\n");
      out.write("                        <label><input type=\"checkbox\"> 记住 下次自动登录</label>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.col -->\r\n");
      out.write("                <div class=\"col-xs-4\">\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary btn-block btn-flat\">登录</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.col -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        <a href=\"#\">忘记密码</a><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.login-box-body -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- /.login-box -->\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 2.2.3 -->\r\n");
      out.write("<!-- Bootstrap 3.3.6 -->\r\n");
      out.write("<!-- iCheck -->\r\n");
      out.write("<script\r\n");
      out.write("        src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/jQuery/jquery-2.2.3.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("        src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("        src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/plugins/iCheck/icheck.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function() {\r\n");
      out.write("        $('input').iCheck({\r\n");
      out.write("            checkboxClass : 'icheckbox_square-blue',\r\n");
      out.write("            radioClass : 'iradio_square-blue',\r\n");
      out.write("            increaseArea : '20%' // optional\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
