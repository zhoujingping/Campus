package ui;

import util.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InsertJFrame extends JFrame{
    private JPanel contentPane;
    private JTextField tf_name;
    private JTextField tf_address;
    private JTextField tf_phone;
    private JTextField tf_weixing;
    private JTextField tf_email;
    private JTextField tf_qq;
    private JTextField tf_self;
    private JTextField tf_number;
    private MainJFrame mainJFrame;

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    InsertJFrame frame = new InsertJFrame(this);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public InsertJFrame(MainJFrame frame) {
        this.mainJFrame=frame;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 466, 473);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel label_x = new JLabel("学号:");
        label_x.setBounds(90, 21, 54, 15);
        contentPane.add(label_x);

        tf_number = new JTextField();
        tf_number.setBounds(125, 25, 204, 21);
        contentPane.add(tf_number);
        tf_number.setColumns(10);

        JLabel label_1 = new JLabel("姓名:");
        label_1.setBounds(90, 71, 54, 15);
        contentPane.add(label_1);

        tf_name = new JTextField();
        tf_name.setBounds(125, 65, 204, 21);
        contentPane.add(tf_name);
        tf_name.setColumns(10);

        JLabel lblNewLabel = new JLabel("家庭住址:");
        lblNewLabel.setBounds(51, 116, 64, 15);
        contentPane.add(lblNewLabel);

        tf_address = new JTextField();
        tf_address.setBounds(125, 113, 204, 21);
        contentPane.add(tf_address);
        tf_address.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("email:");
        lblNewLabel_1.setBounds(76, 162, 39, 15);
        contentPane.add(lblNewLabel_1);

        tf_email = new JTextField();
        tf_email.setBounds(125, 159, 204, 21);
        contentPane.add(tf_email);
        tf_email.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("电话:");
        lblNewLabel_2.setBounds(85, 207, 30, 15);
        contentPane.add(lblNewLabel_2);

        tf_phone = new JTextField();
        tf_phone.setBounds(125, 207, 204, 21);
        contentPane.add(tf_phone);
        tf_phone.setColumns(10);


        JLabel lblNewLabel_3 = new JLabel("微信:");
        lblNewLabel_3.setBounds(76, 247, 54, 15);
        contentPane.add(lblNewLabel_3);
        tf_weixing = new JTextField();
        tf_weixing.setBounds(125, 247, 204, 21);
        contentPane.add(tf_weixing);
        tf_weixing.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("QQ:");
        lblNewLabel_4.setBounds(90, 288, 54, 15);
        contentPane.add(lblNewLabel_4);
        tf_qq = new JTextField();
        tf_qq.setBounds(125, 285, 204, 21);
        contentPane.add(tf_qq);
        tf_qq.setColumns(10);


        JLabel lblNewLabel_5 = new JLabel("个性语言");
        lblNewLabel_5.setBounds(61, 328, 54, 15);
        contentPane.add(lblNewLabel_5);

        tf_self = new JTextField();
        tf_self.setBounds(125, 325, 204, 21);
        contentPane.add(tf_self);
        tf_self.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.setBounds(164, 387, 93, 23);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=tf_name.getText().toString();
                String number=tf_number.getText().toString();
                String qq=tf_qq.getText().toString();
                String weixing=tf_weixing.getText().toString();
                String email=tf_email.getText().toString();
                String address=tf_address.getText().toString();
                String self=tf_self.getText().toString();
                String phone=tf_phone.getText().toString();

                Connection connection= DBUtil.getDBConnect();
                try{
                    PreparedStatement ps=connection.prepareStatement("insert into student values (?,?,'123456',?,?,?,?,?,?)");
                    ps.setNString(1,number);
                    ps.setNString(2,name);
                    ps.setNString(3,address);
                    ps.setNString(4,phone);
                    ps.setNString(5,qq);
                    ps.setNString(6,weixing);
                    ps.setNString(7,email);
                    ps.setNString(8,self);

                    ps.execute();
                        JOptionPane.showMessageDialog(null,"添加成功");
                        frame.updateTable();
                    connection.close();
                    ps.close();
                }catch (SQLException e1){
                    JOptionPane.showMessageDialog(null,"请检查是否填入正确，或者含有相同学号");
                }
            }
        });
        contentPane.add(btnNewButton);
        this.setVisible(true);
    }

}
