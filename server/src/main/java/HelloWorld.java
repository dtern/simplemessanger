
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {

    private String message;
    private String name;
    private String age;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World ";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        name = request.getParameter("name");
        age = request.getParameter("age");
        // Set response content type
        response.setContentType("text/html");
        response.setContentType("charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("Сообщение 1, Сообщение 2, Сообщение 3");
    }

    public void destroy()
    {
        // do nothing.
    }
}
