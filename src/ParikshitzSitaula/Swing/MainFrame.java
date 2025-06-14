package ParikshitzSitaula.Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Library Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titleLabel = new JLabel("Library Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 30, 300, 30);
        add(titleLabel);

        JButton addBookBtn = new JButton("Add Book");
        JButton addUserBtn = new JButton("Add User");
        JButton listBooksBtn = new JButton("List Books");
        JButton listUsersBtn = new JButton("List Users");
        JButton issueBookBtn = new JButton("Issue Book");
        JButton returnBookBtn = new JButton("Return Book");

        addBookBtn.setBounds(30, 80, 540, 40);
        addUserBtn.setBounds(30, 140, 540, 40);
        listBooksBtn.setBounds(30, 200, 540, 40);
        listUsersBtn.setBounds(30, 260, 540, 40);
        issueBookBtn.setBounds(30, 320, 540, 40);
        returnBookBtn.setBounds(30, 380, 540, 40);

        addBookBtn.addActionListener((ActionEvent e) -> new AddBook());
        addUserBtn.addActionListener((ActionEvent e) -> new AddUser());
        listBooksBtn.addActionListener((ActionEvent e) -> new ListBooks());
        listUsersBtn.addActionListener((ActionEvent e) -> new ListUsers());
        issueBookBtn.addActionListener((ActionEvent e) -> new IssueBook());
        returnBookBtn.addActionListener((ActionEvent e) -> new ReturnBook());

        add(addBookBtn);
        add(addUserBtn);
        add(listBooksBtn);
        add(listUsersBtn);
        add(issueBookBtn);
        add(returnBookBtn);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}