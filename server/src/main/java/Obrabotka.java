import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Obrabotka extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("name", "Devcolibri");

        req.getRequestDispatcher("ByeWorld.jsp").forward(req, resp);

        // PrintWriter out = resp.getWriter();
        // out.print("<h1>Hello Servlet</h1>");

    }

}