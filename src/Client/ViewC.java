package Client;

import javax.swing.*;
import java.util.Objects;

public class ViewC {
    private JPanel root;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;

    public void addText(String in) {
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

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JTextField getTextField1() {
        return textField1;
    }
}
