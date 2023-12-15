package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PayBills extends JFrame{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PayBills::new);
    }
    public PayBills() {
        JTextField receiverField = new JTextField(20);
        JTextField ocrField = new JTextField(20);
        JTextField priceField = new JTextField(20);
        JTextArea textArea = new JTextArea(10, 20);
        JButton payButton = new JButton("Pay Bill");
        JButton addButton = new JButton("Add Payment");
        JButton showHistoryButton = new JButton("Show History");
        List<String> paidBills = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Receiver:"));
        inputPanel.add(receiverField);
        inputPanel.add(new JLabel("OCR Number:"));
        inputPanel.add(ocrField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(priceField);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(payButton);
        buttonPanel.add(showHistoryButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Pay Bills");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);

        addButton.addActionListener(e -> addPayment(receiverField, ocrField, priceField, textArea, paidBills));
        payButton.addActionListener(e -> payBill(textArea, paidBills));
        showHistoryButton.addActionListener(e -> showHistory(paidBills));

        frame.pack();
        frame.setVisible(true);
    }
    private void addPayment(JTextField receiverField, JTextField ocrField, JTextField priceField, JTextArea textArea, List<String> paidBills) {
        String receiver = receiverField.getText();
        String ocrNumber = ocrField.getText();
        String amount = priceField.getText();

        if ((!receiver.matches("^[a-zA-Z]+$") && !amount.matches("^\\d+$")) ||
                (!receiver.matches("^[a-zA-Z]+$") && !ocrNumber.matches("^\\d+$")) ||
                (!ocrNumber.matches("^\\d+$") && !amount.matches("^\\d+$"))) {
            JOptionPane.showMessageDialog(null, "Invalid input combination. Receiver must contain only letters, OCR Number must contain only digits, and Amount must contain only digits.");
            return;
        }

        if (ocrNumber.length() != 13) {
            JOptionPane.showMessageDialog(null, "OCR Number must be 13 digits long.");
            return;
        }
        String paymentDetails = "Receiver: " + receiver + "\nOCR Number: " + ocrNumber + "\nAmount: " + amount;
        textArea.append(paymentDetails + "\n\n");  // Add a blank line after each payment

        paidBills.add(paymentDetails);

        receiverField.setText("");
        ocrField.setText("");
        priceField.setText("");
    }
    private void payBill(JTextArea textArea, List<String> paidBills) {
        if (paidBills.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bills have been paid yet.");
            return;
        }

        JFrame paidBillsFrame = new JFrame("Paid Bills History");
        JTextArea paidBillsTextArea = new JTextArea(10, 20);
        for (String paidBill : paidBills) {
            paidBillsTextArea.append(paidBill + "\n\n");  // Add a blank line after each paid bill
        }
        paidBillsFrame.getContentPane().add(new JScrollPane(paidBillsTextArea));
        paidBillsFrame.pack();
        paidBillsFrame.setVisible(true);

        textArea.setText("");
    }
    private void showHistory(List<String> paidBills) {
        if (paidBills.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bills have been paid yet.");
            return;
        }

        JFrame paidBillsFrame = new JFrame("Paid Bills History");
        JTextArea paidBillsTextArea = new JTextArea(10, 20);
        for (String paidBill : paidBills) {
            paidBillsTextArea.append(paidBill + "\n\n");  // Add a blank line after each paid bill
        }
        paidBillsFrame.getContentPane().add(new JScrollPane(paidBillsTextArea));
        paidBillsFrame.pack();
        paidBillsFrame.setVisible(true);
    }
}