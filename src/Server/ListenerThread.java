package Server;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class ListenerThread implements Runnable{
    private BufferedReader in;
    //private PrintStream out;
    private JTextArea out;

    public ListenerThread(BufferedReader in, JTextArea out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!Objects.equals(msg, "")) {
                out.append(msg + "\n");
            }
        }
    }

    public void stop()  {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}