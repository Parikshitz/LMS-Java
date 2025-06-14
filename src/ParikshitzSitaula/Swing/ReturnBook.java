package ParikshitzSitaula.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import ParikshitzSitaula.Services.Library;

public class ReturnBook extends JFrame {
    public ReturnBook() {
        setTitle("Return Book");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Return Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 20, 100, 30);
        add(titleLabel);

        JLabel bookIdLabel = new JLabel("Book ID:");
        JTextField bookIdField = new JTextField();

        bookIdLabel.setBounds(40, 70, 80, 25);
        bookIdField.setBounds(130, 70, 220, 30);

        JButton returnButton = new JButton("Return Book");
        JButton cancelButton = new JButton("Cancel");

        returnButton.setBounds(130, 120, 100, 35);
        cancelButton.setBounds(250, 120, 100, 35);

        returnButton.addActionListener((ActionEvent e) -> {
            try {
                int bookId = Integer.parseInt(bookIdField.getText());
                Library.returnBook(bookId);
                JOptionPane.showMessageDialog(this, "Book returned successfully.");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer for Book ID.",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dispose());

        add(bookIdLabel);
        add(bookIdField);
        add(returnButton);
        add(cancelButton);

        setVisible(true);
    }
}