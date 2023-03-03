package Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class ControllerC {
    ViewC theView;
    ModelC theModel;

    public ControllerC(ViewC theView, ModelC theModel) {
        this.theView = theView;
        this.theModel = theModel;

        String ip = JOptionPane.showInputDialog("IP?", null);

        JFrame frame = new JFrame("Chat (client)");
        frame.setContentPane(theView.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(cl.getResource("skipe.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setIconImage(icon.getImage());

        if (ip.length() < 6) {ip = "10.80.47.63";}
        theModel.start(ip, 1234);
        theModel.getStreams();
        ListenerThread l = new ListenerThread(theModel.in, theView.getTextArea1());
        Thread listener = new Thread(l);
        listener.start();

        theView.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(theView.getInput(), "")) {
                    theModel.out.println("Stranger: " + theView.getInput() + "\n"); //sends msg to other
                }
                theView.addText("YOU: " + theView.getInput() + "\n"); //sends msg in your chat

                //prototype for commands
                if (theView.getInput().startsWith("!")) {
                    if (theView.getInput().startsWith("!test")) {
                        theView.addText("Auto-msg: " + "test Command" + "\n");
                        theModel.out.println("Auto-msg: " + "test Command" + "\n");
                    }
                    else if (theView.getInput().startsWith("!time")) {
                        LocalTime time = LocalTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        theView.addText("Auto-msg: Current local time is " + time.format(formatter) + "\n");
                        theModel.out.println("Auto-msg: Current local time is " + time.format(formatter) + "\n");
                    }
                    else if(theView.getInput().startsWith("!temp")) {
                        String place = "";
                        if (theView.getInput().startsWith("!temp ")) {
                            place = theView.getInput().split(" ")[1];
                        }
                        if (place.length()<3) {
                            place = "bygdea";
                        }
                        String request = "http://api.temperatur.nu/tnu_1.17.php?p=" + place + "&cli=api_demo";
                        String temperature = "";
                        try {
                            URL resource = new URL(request);
                            Scanner urlScanner = new Scanner(resource.openStream());
                            String result = urlScanner.nextLine();
                            temperature = result.split("\"")[23];
                        } catch (Exception err) {
                            err.printStackTrace();
                        }
                        theView.addText("Auto-msg: Current temperature in " + place + " is " + temperature + " grader celcius \n");
                        theModel.out.println("Auto-msg: Current temperature in " + place + " is " + temperature + " grader celcius \n");
                    }
                }

                theView.emptyField(); // empties the input bar
            }
        });

        //listener.stop();
        //theModel.stop();

    }
}
