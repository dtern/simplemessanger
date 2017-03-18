
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class Launcher {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(2222);

        while (true){
            System.out.println("Ожидаем http соединения");

            Socket socket = serverSocket.accept();
            System.out.println("Попался");

            try {
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);

                String line = null;
                while (true) {
                    line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                    System.out.println("The dumb client just sent me this line : " + line);
                    System.out.println("I'm sending it back...");
                    out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                    out.flush(); // заставляем поток закончить передачу данных.
                    System.out.println("Waiting for the next line...");
                    System.out.println();
                }
            }

            catch(Exception x) {
                x.printStackTrace();
            }

            finally {
                socket.close();
            }
        }

    }
}
