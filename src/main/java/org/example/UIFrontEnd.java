package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UIFrontEnd {
    private static String customerName;
    private static String productName;
    private static double VATamount = 15;
    private static double commissionAmount;
    private static double totalSales;
    private static int price;
    private static String[] companies = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Order Entry Form");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 230);
            frame.setLayout(new BorderLayout(10, 10));

            // 1. Create the main form panel with a grid layout (3 rows, 2 columns)
            JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
            formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

            // 2. Customer Name Field
            JLabel nameLabel = new JLabel("Customer Name:");
            JTextField nameField = new JTextField();

            // 3. Product Dropdown from an Array
            JLabel productLabel = new JLabel("Select Product:");
            JComboBox<String> productDropdown = new JComboBox<>(companies);

            // 4. Price Field
            JLabel priceLabel = new JLabel("Price:");
            JTextField priceField = new JTextField();

            // Add labels and fields to the form panel
            formPanel.add(nameLabel);
            formPanel.add(nameField);
            formPanel.add(productLabel);
            formPanel.add(productDropdown);
            formPanel.add(priceLabel);
            formPanel.add(priceField);

            // 5. Submit Button Panel
            JPanel buttonPanel = new JPanel();
            JButton submitButton = new JButton("Process");
            buttonPanel.add(submitButton);

            // 6. Handle Button Click
            submitButton.addActionListener(e -> {
                String customerName = nameField.getText().trim();
                String selectedProduct = (String) productDropdown.getSelectedItem();
                String priceText = priceField.getText().trim();

                if (customerName.isEmpty() || priceText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double price = Double.parseDouble(priceText);
                    ProductCalculations calculations = new ProductCalculations(price);

                    VATamount = calculations.getVat();
                    commissionAmount = calculations.getCommission();
                    totalSales = calculations.getTotal();
                    String summary = String.format(
                            "DATA LOG \n" + "****************************\n" +
                                    "Customer Name: %s\n" +
                                    "Product: %s\n" +
                                    "Price: %.2f\n" +
                                    "VAT Amount: %.2f\n" +
                                    "Commission Amount: %.2f\n" +
                                    "Total Sales: %.2f",
                            customerName, selectedProduct, price, VATamount, commissionAmount, totalSales
                    );
                    JOptionPane.showMessageDialog(frame, summary, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    Path filePath = Path.of("data.txt");
                    Files.writeString(filePath, summary);

                    // Optional: Clear text fields for the next entry
                    nameField.setText("");
                    priceField.setText("");
                    productDropdown.setSelectedIndex(0);
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric price.", "Invalid Price", JOptionPane.ERROR_MESSAGE);
                }
            });

            JButton clearButton = new JButton("Clear");
            buttonPanel.add(clearButton);

            clearButton.addActionListener(e -> {
                nameField.setText("");
                priceField.setText("");
            });


            // Add panels to the main frame
            frame.add(formPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setLocationRelativeTo(null); // Centre on screen
            frame.setVisible(true);
        });
    }
}
