package Server;

import javax.swing.*;

public class ControllerS {
    ViewS theView;
    ModelS theModel;        //does this work?

    public ControllerS(ViewS theView, ModelS theModel) {
        this.theView = theView;
        this.theModel = theModel;

        JFrame frame = new JFrame("ViewC");
        frame.setContentPane(theView.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);


    }
}
