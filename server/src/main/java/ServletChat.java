import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class ServletChat extends HttpServlet {

    ArrayList<Message> messageList = new ArrayList<Message>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // Params
        int id = Integer.parseInt(request.getParameter("id"));

        // String
        StringBuilder sb = new StringBuilder();

        // Check new
        for (Message msg : messageList){
            if (msg.getId() > id){
                sb = sb.append("&id:" + msg.getId() + "&author:" + msg.getAuthor() + "&message:" + msg.getMessage() + "$end");
            }
        }

        // Send new chat strings
        response.getWriter().print(sb.toString());
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        // Get parametr's
        String author = request.getParameter("author");
        String message = request.getParameter("message");
        int messageId = messageList.size();

        // Add message
        Message msg = new Message(messageId, author, message);
        messageList.add(msg);
    }

}
