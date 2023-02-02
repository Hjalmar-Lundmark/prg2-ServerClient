import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket socket;

    PrintWriter out;
    BufferedReader in;

    public Client(String ip, int port) {
        try {
            socket = new Socket(ip,port);
        } catch (IOException e) {
            System.err.println("Failed to connect to server");
            e.printStackTrace();
        }
        System.out.println("Connection ready...");
    }

    private void getStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
    }

    private void runProtocol() {
        System.out.println("chatting...");
        try {
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            out.println("Hjalmar");
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client me = new Client("10.80.47.63", 1234);
        me.getStreams();
        me.runProtocol();
    }
}
