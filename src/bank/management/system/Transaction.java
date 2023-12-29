package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    String pin;

    Transaction(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        b8 = new JButton("BACK");

        // Set layout manager for the frame
        setLayout(new BorderLayout());

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        buttonPanel.add(b8);

        // Create a panel for the label
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.BLACK);
        labelPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        labelPanel.add(l1);

        // Add panels to the frame
        add(labelPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(l2, BorderLayout.WEST);

        // Add action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        setSize(960, 600);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transaction("");
    }
}
