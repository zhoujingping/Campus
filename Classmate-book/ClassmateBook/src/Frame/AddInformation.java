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

import Dao.InformationDao;
import model.information;


public class AddInformation extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	
	private JTextField id = null;
	private JTextField name = null;
	private JTextField address = null;
	private JTextField phone = null;
	private JTextField wchat = null;
	private JTextField email = null;
	private JTextField qq = null;
	private JTextField classid = null;
	private JTextField message = null;
	private String gid;
	private int i;
	

	private static information information = new information();
	
	
	
	public AddInformation(){
		setTitle("添加校友");								//设置窗体标题
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			//单击关闭按钮是关闭
		setSize(350, 800);
		contentPane = new JPanel();								//创建面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//设置边框
		setContentPane(contentPane); 							//应用面板
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("ID：");
		panel1.add(label1);
		id = new JTextField();
		panel1.add(id);
		id.setColumns(10);
		id.setBackground(Color.LIGHT_GRAY);
		id.setEditable(false);
		panel1.setBorder(new EmptyBorder(10, 43, 10, 20));
		
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("姓名：");
		panel2.add(label2);
		name = new JTextField();
		panel2.add(name);
		name.setColumns(10);
		panel2.setBorder(new EmptyBorder(10, 33, 10, 20));
		
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel("家庭住址：");
		panel3.add(label3);
		address = new JTextField();
		panel3.add(address);
		address.setColumns(10);
		panel3.setBorder(new EmptyBorder(10, 13, 10, 20));
		
		JPanel panel4 = new JPanel();
		JLabel label4 = new JLabel("电话：");
		panel4.add(label4);
		phone = new JTextField();
		panel4.add(phone);
		phone.setColumns(10);
		panel4.setBorder(new EmptyBorder(10, 33, 10, 20));
		
		JPanel panel5 = new JPanel();
		JLabel label5 = new JLabel("微信：");
		panel5.add(label5);
		wchat = new JTextField();
		panel5.add(wchat);
		wchat.setColumns(10);
		panel5.setBorder(new EmptyBorder(10, 33, 10, 20));
		
		JPanel panel6 = new JPanel();
		JLabel label6 = new JLabel("邮箱：");
		panel6.add(label6);
		email = new JTextField();
		panel6.add(email);
		email.setColumns(10);
		panel6.setBorder(new EmptyBorder(10, 23, 10, 20));
		
		JPanel panel7 = new JPanel();
		JLabel label7 = new JLabel("QQ：");
		panel7.add(label4);
		qq = new JTextField();
		panel4.add(qq);
		qq.setColumns(10);
		panel4.setBorder(new EmptyBorder(10, 33, 10, 20));
		
		JPanel panel8 = new JPanel();
		JLabel label8 = new JLabel("班级ID：");
		panel8.add(label8);
		classid = new JTextField();
		panel8.add(classid);
		classid.setColumns(10);
		panel8.setBorder(new EmptyBorder(10, 23, 10, 20));
		
		JPanel panel9 = new JPanel();
		JLabel label9 = new JLabel("个性语言：");
		panel9.add(label9);
		message = new JTextField();
		panel9.add(message);
		message.setColumns(10);
		panel9.setBorder(new EmptyBorder(10, 23, 10, 20));
		
		JButton add = new JButton("添加");
		JPanel panel10 = new JPanel();
		panel10.add(add);
		panel10.setBorder(new EmptyBorder(5, 33, 10, 20));
		
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(panel4);
		contentPane.add(panel9);
		
		System.out.println(InformationFrame.getnum());
		gid = String.valueOf(InformationFrame.getnum());
		System.out.println(gid);
		id.setText(gid);
		information.setId(Integer.parseInt(gid));
		System.out.println(information.getId());
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!name.getText().equals("")) {
					information.setName(name.getText());
					System.out.println(name);
				}else {
					information.setName(null);
				}
				if (!address.getText().equals("")) {
					information.setName(address.getText());
				}else {
					information.setName(null);
				}
				if (!phone.getText().equals("")) {
					information.setPhone(phone.getText());
				}else {
					information.setPhone(null);
				}
				if (!wchat.getText().equals("")) {
					information.setWchat(wchat.getText());
				}else {
					information.setWchat(null);
				}
				if (!email.getText().equals("")) {
					information.setEmail(email.getText());
				}else {
					information.setEmail(null);
				}
				if (!qq.getText().equals("")) {
					information.setQQ(qq.getText());
				}else {
					information.setQQ(null);
				}
				if (!classid.getText().equals("")) {
					information.setClassId(Integer.parseInt(classid.getText()));
				}else {
					information.setClassId(0);
				}
				if (!message.getText().equals("")) {
					information.setMessage(message.getText());
				}else {
					information.setMessage(null);
				}
				InformationFrame.setnum(InformationFrame.getnum());
				i = InformationDao.addinformation(information);
				JOptionPane.showMessageDialog(null, "添加成功");
				
				Vector v = new Vector();
				v.add(AddInformation.getInformation().getId());
				v.add(AddInformation.getInformation().getName());
				v.add(AddInformation.getInformation().getAddress());
				v.add(AddInformation.getInformation().getPhone());
				v.add(AddInformation.getInformation().getWchat());
				v.add(AddInformation.getInformation().getEmail());
				v.add(AddInformation.getInformation().getQQ());
				v.add(AddInformation.getInformation().getClassId());
				v.add(AddInformation.getInformation().getMessage());
				AdminFrame.dtm.addRow(v);
				
				dispose();
			}
		});
		
		
	}
	public static information getInformation() {
		return information;
	}
}
