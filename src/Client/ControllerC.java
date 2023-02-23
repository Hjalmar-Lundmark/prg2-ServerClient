package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerC {
    ViewC theView;
    ModelC theModel;

    public ControllerC(ViewC theView, ModelC theModel) {
        this.theView = theView;
        this.theModel = theModel;

        JFrame frame = new JFrame("Chat (client)");
        frame.setContentPane(theView.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);


        theModel.start("10.80.47.63", 1234);
        theModel.getStreams();
        ListenerThread l = new ListenerThread(theModel.in, /*System.out*/ theView.getTextArea1());
        Thread listener = new Thread(l);
        listener.start();

        theView.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theModel.out.println("CLIENT: " + theView.getInput() + "\n");
                theView.addText("YOU: " + theView.getInput() + "\n");
            }
        });

        //listener.stop();
        //theModel.stop();

    }
}
