package ParikshitzSitaula.Swing;

import ParikshitzSitaula.entities.Users;
import ParikshitzSitaula.Services.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {
    public AddUser() {
        setTitle("Add User");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Add New User");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 20, 150, 30);
        add(titleLabel);

        JLabel nameLabel = new JLabel("User Name:");
        JTextField nameField = new JTextField();

        nameLabel.setBounds(40, 70, 80, 25);
        nameField.setBounds(130, 70, 270, 30);

        JButton addButton = new JButton("Add User");
        JButton cancelButton = new JButton("Cancel");

        addButton.setBounds(130, 140, 120, 35);
        cancelButton.setBounds(280, 140, 120, 35);

        addButton.addActionListener((ActionEvent e) -> {
            try {
                String name = nameField.getText().trim();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a User Name.");
                    return;
                }

                Users user = new Users(0, name);
                Library.addUser(user);
                JOptionPane.showMessageDialog(this, "User added successfully.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        cancelButton.addActionListener(e -> dispose());

        add(nameLabel);
        add(nameField);
        add(addButton);
        add(cancelButton);

        setVisible(true);
    }
}