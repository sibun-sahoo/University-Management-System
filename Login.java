package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login ,back;
    Login() {

        JLabel labelName = new JLabel("Username:");
        labelName.setBounds(40,20,100,20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150,20,150,20);
        add(textFieldName);


        JLabel labelPass = new JLabel("Password:");
        labelPass.setBounds(40,70,100,20);
        add(labelPass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(40,140,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        back = new JButton("Back");
        back.setBounds(190, 140 ,100 , 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200 , 200 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,600,600);
        add(image);



        setSize(600,300);
        setLocation(500,250);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login) {

            String username = textFieldName.getText();
            String password = passwordField.getText();

            String query = "select * from login where usename = '"+username+"' and password ='"+password+"' ";

                try{
                    if(username.equals("") || password.equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the fields");
                    }
                    else {
                        DatabaseConnection conn1 = new DatabaseConnection();
                        ResultSet resultSet = conn1.st.executeQuery(query);

                        if (resultSet.next()) {
                            setVisible(false);
                            new Main_class();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                        }
                    }

            } catch(Exception E){
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
