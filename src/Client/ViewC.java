package Client;

import javax.swing.*;
import java.util.Objects;

public class ViewC {
    private JPanel root;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;

    public void AddText(String in) {
        if (!Objects.equals(textField1.getText(), "")) {
            textArea1.append(in);
            emptyField();
        }
    }

    public String getInput() {
        return textField1.getText();
    }
    public void emptyField() {
        textField1.setText("");
    }

    public JPanel getPanel() {
        return root;
    }

    public JButton getButton1() {
        return button1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ViewC");
        frame.setContentPane(new ViewC().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
