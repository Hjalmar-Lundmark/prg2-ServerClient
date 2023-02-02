import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    Socket client;

    PrintWriter out;
    BufferedReader in;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to open serversocket.");
            e.printStackTrace();
        }
        System.out.println("Server started...");
    }

    private void acceptClient() {
        try {
            client = server.accept();
        } catch (IOException e) {
            System.err.println("Failed to connect to client");
            e.printStackTrace();
        }
        System.out.println("client connected...");
    }

    private void getStreams() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
    }

    private void runProtocol() {
        System.out.println("chatting...");
        out.println("Welcome!");
        out.println("What's your name?");
        String name = null;
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client " + name + " is here");
        out.println("Nice to see you, " + name);
        out.flush();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server(1234);
        s.acceptClient();
        s.getStreams();
        s.runProtocol();
    }
}