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

import Dao.DoctorDao;
import Dao.NurseDao;
import Dao.PatientDao;
import Dao.RootDao;
import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Root;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 2902174395721593804L;
	private JPanel contentPane;
	private JTextField username = null;
	private JPasswordField password = null;
	private JRadioButton root = new JRadioButton("管理员");
	private JRadioButton doctor = new JRadioButton("医生",true);
	private JRadioButton patient = new JRadioButton("病人");
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
		setTitle("医院信息管理系统");								//设置窗体标题
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
		panel4.add(patient);
		panel4.add(doctor);
		panel4.add(root);
		ButtonGroup group = new ButtonGroup();
		group.add(patient);
		group.add(doctor);
		group.add(root);
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
				if (root.isSelected()) {
					Root root = new Root();							//创建Doctor类的实例
					root.setnum(uname); 							//封装用户名
					root.setpsd(pswd); 								//封装密码
					if(RootDao.okRoot(root)) {						//如果用户名密码正确
						RootFrame rootclass = new RootFrame(uname);		//创建管理员操作界面
						rootclass.setVisible(true);
						Toolkit toolkit = rootclass.getToolkit();	//获得Toolkit对象
						Dimension dm = toolkit.getScreenSize();		//获得屏幕的大小
						//使主屏幕居中
						rootclass.setLocation((dm.width - rootclass.getWidth())/2, (dm.height - rootclass.getHeight())/2);
						dispose();
					}
				} else if (doctor.isSelected()) {
					Doctor doctor = new Doctor();
					doctor.setdno(uname);
					doctor.setpsd(pswd);
					if(DoctorDao.okDoctor(doctor)) {						//如果用户名密码正确
						DoctorFrame doctorclass = new DoctorFrame(uname);		//创建管理员操作界面
						doctorclass.setVisible(true);
						Toolkit toolkit = doctorclass.getToolkit();	//获得Toolkit对象
						Dimension dm = toolkit.getScreenSize();		//获得屏幕的大小
						//使主屏幕居中
						doctorclass.setLocation((dm.width - doctorclass.getWidth())/2, (dm.height - doctorclass.getHeight())/2);
						dispose();
					}
				} else if (patient.isSelected()) {
					Patient patient = new Patient();
					patient.setIC(uname);
					patient.setpsd(pswd);
					if(PatientDao.okPatient(patient)) {						//如果用户名密码正确
						PatientFrame patientFrame = new PatientFrame(uname);		//创建管理员操作界面
						patientFrame.setVisible(true);
						Toolkit toolkit = patientFrame.getToolkit();	//获得Toolkit对象
						Dimension dm = toolkit.getScreenSize();		//获得屏幕的大小
						//使主屏幕居中
						patientFrame.setLocation((dm.width - patientFrame.getWidth())/2, (dm.height - patientFrame.getHeight())/2);
						dispose();
					}
				}
			}
		});
		panel5.add(login);
	}
}
