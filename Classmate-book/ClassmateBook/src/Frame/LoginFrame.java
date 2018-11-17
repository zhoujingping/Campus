package Frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dao.AdminDao;
import model.admin;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 2902174395721593804L;
	private JPanel contentPane;
	private JTextField username = null;
	private JPasswordField password = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					LoginFrame frame = new LoginFrame();	//创建窗体
					frame.setVisible(true); 				//设置窗口可见
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	public LoginFrame() {
		setTitle("校友通讯录");								//设置窗体标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//单击关闭按钮是关闭
		setBounds(500, 200, 350, 250);
		contentPane = new JPanel();								//创建面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//设置边框
		setContentPane(contentPane); 							//应用面板
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));		//设置布局管理器
		JPanel panel1 = new JPanel();							//创建面板
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel1);
		JLabel label1 = new JLabel("登录");						//标题
		panel1.add(label1);
		JPanel panel2 = new JPanel();							//创建面板
		FlowLayout flowLayout2 = (FlowLayout) panel2.getLayout();
		flowLayout2.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel2);
		JLabel label2 = new JLabel("用户名：");
		panel2.add(label2);
		username = new JTextField();
		panel2.add(username);
		username.setColumns(18);
		JPanel panel3 = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) panel3.getLayout();
		flowLayout3.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel3);
		JLabel label3 = new JLabel("密    码：");
		panel3.add(label3);
		password = new JPasswordField();
		password.setColumns(18);
		panel3.add(password);
		JPanel panel4 = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) panel4.getLayout();
		flowLayout4.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel4);
		ButtonGroup group = new ButtonGroup();
		JPanel panel5 = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) panel5.getLayout();
		flowLayout5.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel5);
		JButton login = new JButton("登录");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String uname = username.getText().trim();			//获得用户名
				String pswd = new String(password.getPassword());	//获得密码
				admin ad = new admin();							
				ad.setUserName(uname); 							//封装用户名
				ad.setPassWord(pswd); 								//封装密码
				if(AdminDao.okAdmin(ad)) {						//如果用户名密码正确
					AdminFrame rootclass = new AdminFrame();		//创建管理员操作界面
					rootclass.setVisible(true);
					Toolkit toolkit = rootclass.getToolkit();	//获得Toolkit对象
					Dimension dm = toolkit.getScreenSize();		//获得屏幕的大小
					//使主屏幕居中
					rootclass.setLocation((dm.width - rootclass.getWidth())/2, (dm.height - rootclass.getHeight())/2);
					dispose();
				}
			}
		});
		panel5.add(login);
	}
}
