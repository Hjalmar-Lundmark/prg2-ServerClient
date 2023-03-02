package Server;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ControllerS {
    ViewS theView;
    ModelS theModel;        //does this work?

    public ControllerS(ViewS theView, ModelS theModel) {
        this.theView = theView;
        this.theModel = theModel;

        JFrame frame = new JFrame("Chat (Server)");
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

        // idk
        theModel.acceptClient();
        theModel.getStreams();
        ListenerThread l = new ListenerThread(theModel.in, theView.getTextArea1());
        Thread listener = new Thread(l);
        listener.start();


        theView.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(theView.getInput(), "")) {
                    theModel.out.println("Stranger: " + theView.getInput() + "\n");// sends your msg
                }
                theView.addText("YOU: " + theView.getInput() + "\n");// sends msg in your chat

                //prototype for commands
                if (theView.getInput().startsWith("!")) {
                    if (theView.getInput().startsWith("!testcomm")) {
                        theView.addText("Auto-msg: " + "test Command" + "\n");
                        theModel.out.println("Auto-msg: " + "test Command" + "\n");
                    } else if (theView.getInput().startsWith("!time")) {
                        LocalTime time = LocalTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        theView.addText("Auto-msg: Current local time is " + time.format(formatter) + "\n");
                        theModel.out.println("Auto-msg: Current local time is " + time.format(formatter) + "\n");
                    }
                }

                theView.emptyField();
            }
        });


        //listener.stop();
        //theModel.shutdown();

    }
}
