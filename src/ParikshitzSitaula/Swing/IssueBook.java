package ParikshitzSitaula.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import ParikshitzSitaula.Services.Library;

public class IssueBook extends JFrame {
    public IssueBook() {
        setTitle("Issue Book");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Issue Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 20, 100, 30);
        add(titleLabel);

        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        JLabel bookIdLabel = new JLabel("Book ID:");
        JTextField bookIdField = new JTextField();

        userIdLabel.setBounds(40, 70, 80, 25);
        userIdField.setBounds(130, 70, 220, 30);
        bookIdLabel.setBounds(40, 120, 80, 25);
        bookIdField.setBounds(130, 120, 220, 30);

        JButton issueButton = new JButton("Issue Book");
        JButton cancelButton = new JButton("Cancel");

        issueButton.setBounds(130, 180, 100, 35);
        cancelButton.setBounds(250, 180, 100, 35);

        issueButton.addActionListener((ActionEvent e) -> {
            try {
                int userId = Integer.parseInt(userIdField.getText());
                int bookId = Integer.parseInt(bookIdField.getText());
                Library.issueBook(bookId, userId);
                JOptionPane.showMessageDialog(this, "Book issued successfully.");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid integers for IDs.",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dispose());

        add(userIdLabel);
        add(userIdField);
        add(bookIdLabel);
        add(bookIdField);
        add(issueButton);
        add(cancelButton);

        setVisible(true);
    }
}