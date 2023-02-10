package Client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ModelC {
    Socket socket;
    PrintWriter out;
    BufferedReader in;

    public ModelC() {
        /* // bad code, maybe rewrite everything from Client.java in here
        Client me = new Client("10.80.47.63", 1234);
        me.getStreams();
        ListenerThread l = new ListenerThread(me.in, System.out);
        Thread listener = new Thread(l);
        listener.start();
        me.runProtocol();
        listener.stop();
        me.shutDown();
        */


    }

    public void sendMsg() {

    }

    /*
    public static void main(String[] args) {
        ModelC m = new ModelC();


    }

     */
}
