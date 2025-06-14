package ParikshitzSitaula.Swing;

import ParikshitzSitaula.entities.Book;
import ParikshitzSitaula.Services.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {
    public AddBook() {
        setTitle("Add Book");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Add New Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 20, 150, 30);
        add(titleLabel);

        JLabel idLabel = new JLabel("Book ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Book Name:");
        JTextField nameField = new JTextField();
        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField();

        idLabel.setBounds(40, 70, 80, 25);
        idField.setBounds(130, 70, 270, 30);
        nameLabel.setBounds(40, 120, 80, 25);
        nameField.setBounds(130, 120, 270, 30);
        authorLabel.setBounds(40, 170, 80, 25);
        authorField.setBounds(130, 170, 270, 30);

        JButton addButton = new JButton("Add Book");
        JButton cancelButton = new JButton("Cancel");

        addButton.setBounds(130, 240, 120, 35);
        cancelButton.setBounds(280, 240, 120, 35);

        addButton.addActionListener((ActionEvent e) -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String author = authorField.getText();
                Book book = new Book(id, name, author);
                Library.addBook(book);
                JOptionPane.showMessageDialog(this, "Book added successfully.");
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
        add(authorLabel);
        add(authorField);
        add(addButton);
        add(cancelButton);

        setVisible(true);
    }
}