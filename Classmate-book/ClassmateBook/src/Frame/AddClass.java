package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.ClassDao;
import model.Class;

public class AddClass extends JFrame{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JPanel contentPane;
    
    private JTextField dno = null;
    private JTextField dname = null;
    private JTextField dsex = null;
    private JTextField dage = null;
    private JTextField employ = null;
    private JTextField phone = null;
    private JTextField ono = null;
    private JTextField title = null;
    private String gdno;
    private int i;
    

    private static Class class = new Class();
    
    
    
    public AddClass(){
        setTitle("���ҽ��");                             //���ô������
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);          //�����رհ�ť�ǹر�
        setSize(350, 550);
        contentPane = new JPanel();                             //�������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));     //���ñ߿�
        setContentPane(contentPane);                            //Ӧ�����
        
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("ҽ�����ţ�");
        panel1.add(label1);
        dno = new JTextField();
        panel1.add(dno);
        dno.setColumns(10);
        dno.setBackground(Color.LIGHT_GRAY);
        dno.setEditable(false);
        panel1.setBorder(new EmptyBorder(10, 13, 10, 20));
        
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("������");
        panel2.add(label2);
        dname = new JTextField();
        panel2.add(dname);
        dname.setColumns(10);
        panel2.setBorder(new EmptyBorder(10, 33, 10, 20));
        
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("�Ա�");
        panel3.add(label3);
        dsex = new JTextField();
        panel3.add(dsex);
        dsex.setColumns(10);
        panel3.setBorder(new EmptyBorder(10, 33, 10, 20));
        
        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("���䣺");
        panel4.add(label4);
        dage = new JTextField();
        panel4.add(dage);
        dage.setColumns(10);
        panel4.setBorder(new EmptyBorder(10, 33, 10, 20));
        
        JPanel panel5 = new JPanel();
        JLabel label6 = new JLabel("���Һţ�");
        panel5.add(label6);
        ono = new JTextField();
        panel5.add(ono);
        ono.setColumns(10);
        panel5.setBorder(new EmptyBorder(10, 23, 10, 20));
        
        JPanel panel6 = new JPanel();
        JLabel label5 = new JLabel("���ʣ�");
        panel6.add(label5);
        employ = new JTextField();
        panel6.add(employ);
        employ.setColumns(10);
        panel6.setBorder(new EmptyBorder(10, 33, 10, 20));
        
        JPanel panel7 = new JPanel();
        JLabel label7 = new JLabel("�绰��");
        panel7.add(label7);
        phone = new JTextField();
        panel7.add(phone);
        phone.setColumns(10);
        panel7.setBorder(new EmptyBorder(10, 33, 10, 20));
        
        JPanel panel8 = new JPanel();
        JLabel label8 = new JLabel("ְ�ƣ�");
        panel8.add(label8);
        title = new JTextField();
        panel8.add(title);
        title.setColumns(10);
        panel8.setBorder(new EmptyBorder(10, 33, 10, 20));
        
        JButton add = new JButton("���");
        JPanel panel9 = new JPanel();
        panel9.add(add);
        panel9.setBorder(new EmptyBorder(5, 33, 10, 20));
        
        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(panel3);
        contentPane.add(panel4);
        contentPane.add(panel5);
        contentPane.add(panel6);
        contentPane.add(panel7);
        contentPane.add(panel8);
        contentPane.add(panel9);
        
        System.out.println(ClassManegeFrame.getnum());
        gdno = String.format("%08d", ClassManegeFrame.getnum());
        System.out.println(gdno);
        dno.setText(gdno);
        class.setdno(gdno);
        System.out.println(class.getdno());
        class.setpsd("00000000");
        
        add.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (!dname.getText().equals("")) {
                    class.setdname(dname.getText());
                    System.out.println(dname);
                }else {
                    class.setdname(null);
                }
                if (!dsex.getText().equals("")) {
                    class.setdsex(dsex.getText());
                }else {
                    class.setdsex(null);
                }
                if (!dage.getText().equals("")) {
                    class.setdage(Integer.parseInt(dage.getText()));
                }else {
                    class.setdage(0);
                }
                if (!employ.getText().equals("")) {
                    class.setemploy(Integer.parseInt(employ.getText()));
                }else {
                    class.setemploy(0);
                }
                if (!phone.getText().equals("")) {
                    class.setphone(phone.getText());
                }else {
                    class.setphone(null);
                }
                if (!ono.getText().equals("")) {
                    class.setono(ono.getText());
                }else {
                    class.setono(null);
                }
                if (!title.getText().equals("")) {
                    class.settitle(title.getText());
                }else {
                    class.settitle(null);
                }
                ClassManegeFrame.setnum(ClassManegeFrame.getnum());
                i = ClassDao.addClass(class);
                JOptionPane.showMessageDialog(null, "��ӳɹ�");
                
                Vector v = new Vector();
                v.add(AddClass.getclass().getdno());
                v.add(AddClass.getclass().getdname());
                v.add(AddClass.getclass().getdsex());
                v.add(AddClass.getclass().getdage());
                v.add(AddClass.getclass().getemploy());
                v.add(AddClass.getclass().getono());
                v.add(AddClass.getclass().getphone());
                v.add(AddClass.getclass().gettitle());
                ClassManegeFrame.dtm.addRow(v);
                
                dispose();
            }
        });
        
        
    }
    public static Class getclass() {
        return class;
    }
    
}


