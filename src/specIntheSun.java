import javax.swing.*;
import java.awt.event.*;
public class specIntheSun extends JFrame implements ActionListener, KeyListener {
    private JLabel Taxable;
    private JTextField displayAfter;
    private JPanel Panel;
    private JTextField enterData;
    private JButton calculateButton;
    private JButton Exit;
    private String read = "";

    public specIntheSun() {
        calculateButton.addActionListener(this);
        Exit.addActionListener(this);

        // when pressing a button
        // Enter key - calculates
        // Esc key - Closes program

        Exit.addKeyListener(this);
        enterData.addKeyListener(this);

        setPanelSize();
        displayAfter.setEditable(false);
    }

    // Not sure how to calculate the formulas...
    // No matter how i tried.
    private double calculateTax(String num) {
        int a;
        double total;
        a = Integer.parseInt(num);
        if (a >= 0 && a < 9875) {
            total = a * 0.1;
        } else if (a >= 9876 && a <= 40125) {
            total = (0.12 * (a - 987.5));
        } else if (a >= 40126 && a <= 85525) {
            total = 0.22 * (a - 4617.5);
        } else if (a >= 85526 && a <= 163000) {
            total = 0.24 * (a - 14605);
        } else if (a >= 163301 && a <= 207350) {
            total = 0.32 * (a - 33271.5);
        } else if (a >= 207351 && a <= 518400) {
            total = 0.35 * (a - 47367.5);
        } else {
            total = 0.37 * (a - 156235);
        }
        return total;
    }

    private void displayOnBox() {
        displayAfter.setText(display(calculateTax(read)));
    }

    private String display(double total) {
        return String.format("%,.2f", total);
    }

    private void setPanelSize() {
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(Panel);
        setTitle("Income Tax Calculator");
    }

    //this gives life to buttons and
    //retrieve data from textbox.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            if (read.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter something");
            } else {
                read = enterData.getText();
                calculateTax(read);
                displayOnBox();
            }
        }
        if (e.getSource() == Exit) {
            System.exit(1);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (read.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter something");
            } else {
                read = enterData.getText();
                calculateTax(read);
                displayOnBox();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ;
    }
}
