package ParikshitzSitaula.Swing;

import ParikshitzSitaula.entities.Users;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import ParikshitzSitaula.Services.Library;

public class AddUser extends JFrame {
    public AddUser() {
        setTitle("Add User");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Add New User");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(140, 20, 120, 30);
        add(titleLabel);

        JLabel idLabel = new JLabel("User ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("User Name:");
        JTextField nameField = new JTextField();

        idLabel.setBounds(40, 70, 80, 25);
        idField.setBounds(130, 70, 220, 30);
        nameLabel.setBounds(40, 120, 80, 25);
        nameField.setBounds(130, 120, 220, 30);

        JButton addButton = new JButton("Add User");
        JButton cancelButton = new JButton("Cancel");

        addButton.setBounds(130, 170, 100, 35);
        cancelButton.setBounds(250, 170, 100, 35);

        addButton.addActionListener((ActionEvent e) -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                Users user = new Users(id, name);
                Library.addUser(user);
                JOptionPane.showMessageDialog(this, "User added successfully.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        cancelButton.addActionListener(e -> dispose());

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(addButton);
        add(cancelButton);

        setVisible(true);
    }
}