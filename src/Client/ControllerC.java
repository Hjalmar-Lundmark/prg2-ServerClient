package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerC {
    ViewC theView;
    ModelC theModel;        //does this work?

    public ControllerC(ViewC theView, ModelC theModel) {
        this.theView = theView;
        this.theModel = theModel;

        JFrame frame = new JFrame("ViewC");
        frame.setContentPane(theView.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);


        theModel.start("10.80.47.63", 1234);
        theModel.getStreams();
        ListenerThread l = new ListenerThread(theModel.in, System.out);
        Thread listener = new Thread(l);
        listener.start();
        //theModel.protocol();
        /*Scanner tgb = new Scanner(theView.getInput());
        theView.addText("chatting..." + "\n");
        String msg = "";
        while (!msg.equals("QUIT")) {
            msg = tgb.nextLine();
            theView.addText("CLIENT: " + msg + "\n");
            theModel.out.println("CLIENT: " + msg);
        }
        */

        theView.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theView.addText("YOU: " + theView.getInput() + "\n");
                theModel.out.println("CLIENT: " + theView.getInput());
            }
        });

        listener.stop();
        theModel.stop();

    }
}
