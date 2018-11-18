package ui;

import util.DBUtil;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginJFrame frame = new LoginJFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("学号");
        lblNewLabel.setBounds(96, 83, 54, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("密码");
        lblNewLabel_1.setBounds(96, 130, 54, 15);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(201, 80, 148, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(201, 127, 148, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String account=textField.getText().toString();
                String password=textField_1.getText().toString();

                if(login(account,password)==true) {
                    new MainJFrame();
                    LoginJFrame.this.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"账号或密码错误");
                }
            }
        });
        btnNewButton.setBounds(154, 194, 93, 23);
        contentPane.add(btnNewButton);
    }

    public boolean login(String account,String password) {

        boolean ok=false;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DBUtil.getDBConnect();
            //Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
            String sql = "select * from student where snumber=? and spassword=?";
            PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
            pstm.setNString(1, account);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();

            rs.last();
            if(rs.getRow()!=0) {
                ok=true;
            }

        }  catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ok;
    }

}
