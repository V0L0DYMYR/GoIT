package ua.goit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HtmlFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<form action=\"/htmlForm\" method=\"post\">");
        out.println("<input name=\"login\" type=\"text\">");
        out.println("<input name=\"password\" type=\"password\">");
        out.println("<button type=\"submit\">Submit</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("login");
        resp.getWriter().println(String.format("<h1>Hello and welcome %s</h1>", userName));
    }

    private void showFormParameters(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String,String[]> parameterMap = req.getParameterMap();
        StringBuilder result = new StringBuilder();
        result.append("POST\n");
        for (String paramName : parameterMap.keySet()) {
            String[] ParamValue = parameterMap.get(paramName);
            StringBuilder buf = new StringBuilder();
            for (String s : ParamValue) {
                buf.append(s).append(" | ");
            }

            result.append(String.format("[%s : %s]", paramName, buf.toString()));
        }
        resp.getWriter().println(result.toString());
    }
}
