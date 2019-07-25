import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 同步阻塞IO，只能由一个客户端连接进来
 */
public class BioServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket=new ServerSocket(8088);
        Socket socket=serverSocket.accept();//阻塞点，不断等待客户端连接
        Scanner input=new Scanner(socket.getInputStream());
        while (true){
            String request=input.nextLine();//组赛点，不断等代客户端写
            if("quit".equals(request))
                break;
            String response="From BioServer Hello"+request+"\n";
            socket.getOutputStream().write(response.getBytes());
            System.out.println(request);
        }
    }
}
