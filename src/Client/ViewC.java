package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewC extends JFrame {
    private JPanel root;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;

    public ViewC() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void AddText(String in) {
        textArea1.append(in);
    }

    public String getInput() {
        return textField1.getText();
    }

    public JPanel getPanel() {
        return root;
    }

    void addRunListener(ActionListener running) {
        button1.addActionListener(running);
    }

}
