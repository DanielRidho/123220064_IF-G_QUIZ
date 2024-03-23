/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg123220064_if.g_quiz;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton buttonLogin;

    public LoginFrame() {
        setTitle("Halaman Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textFieldUsername = new JTextField();
        passwordField = new JPasswordField();
        buttonLogin = new JButton("Log-in");

        setLayout(new GridLayout(3, 2, 10, 10));
      
        add(new JLabel("Username:"));
        add(textFieldUsername);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel());
        add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("123220064") && password.equals("123123")) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login berhasil!");
                
                    InputNilaiFrame inputNilaiFrame = new InputNilaiFrame();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login gagal! Username atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }
}
