package Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        // idk
        theModel.acceptClient();
        theModel.getStreams();
        ListenerThread l = new ListenerThread(theModel.in, theView.getTextArea1());
        Thread listener = new Thread(l);
        listener.start();


        theView.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (theView.getInput() != "") {
                    theModel.out.println("Server: " + theView.getInput() + "\n");
                }
                theView.addText("YOU: " + theView.getInput() + "\n");
            }
        });


        //listener.stop();
        //theModel.shutdown();

    }
}
