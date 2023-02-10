package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerC extends JFrame {
    ViewC theView;
    ModelC theModel;        //does this work?

    public ControllerC(ViewC theView, ModelC theModel) {
        this.theView = theView;
        this.theModel = theModel;

        /*
        this.setContentPane(theView.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        */

        JFrame frame = new JFrame("ViewC");
        frame.setContentPane(new ViewC().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);


        this.theView.addRunListener(new runListener());     //idk
    }

    private class runListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


        }
    }


}
