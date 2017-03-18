import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServletChat extends HttpServlet {

    // Server connect soket
    Socket serverSocket = null;

    // Server connect params
    private int serverPort = 6666;
    private String address = "127.0.0.1";

    public ServletChat() {
        connectServer();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String code = request.getParameter("code");

        System.out.println("Имя: " + name);
        System.out.println("Id: " + id);
        System.out.println("Code: " + code);

        /*
        // Set response content type
        response.setContentType("text/html");
        response.setContentType("charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("Сообщение 1, Сообщение 2, Сообщение 3");
        */
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String code = request.getParameter("code");

        System.out.println("Имя: " + name);
        System.out.println("Id: " + id);
        System.out.println("Code: " + code);

        String complateString = name + ": " + code;
        String serverAnswerString;

        // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
        OutputStream sout = serverSocket.getOutputStream();
        InputStream ssin = serverSocket.getInputStream();

        // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
        DataOutputStream out = new DataOutputStream(sout);
        DataInputStream sin = new DataInputStream(ssin);


            out.writeUTF(complateString); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            serverAnswerString = sin.readUTF(); // ждем пока сервер отошлет строку текста.

            response.getWriter().print("sdfgsdfsdfsdf");
            System.out.println("Ответ сервера: " + serverAnswerString);

            /*PrintWriter writer = response.getWriter();
            writer.print(serverAnswerString);*/


        /*
        // Set response content type
        response.setContentType("text/html");
        response.setContentType("charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("Сообщение 1, Сообщение 2, Сообщение 3");
        */
    }


    private void connectServer(){
        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            System.out.println("Вы хотите работать с этим IPадресом " + address + " и портом? " + serverPort + "?");
            serverSocket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Соединение установлено");
    } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
