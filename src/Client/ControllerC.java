package Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

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
        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(cl.getResource("skipe.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setIconImage(icon.getImage());

        theModel.start("10.80.47.63", 1234);
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
                theView.emptyField();
            }
        });

        //listener.stop();
        //theModel.stop();

    }
}
