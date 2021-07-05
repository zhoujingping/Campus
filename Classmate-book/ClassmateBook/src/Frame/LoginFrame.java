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
					LoginFrame frame = new LoginFrame();	//��������
					frame.setVisible(true); 				//���ô��ڿɼ�
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	public LoginFrame() {
		setTitle("У��ͨѶ¼");								//���ô������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//�����رհ�ť�ǹر�
		setBounds(500, 200, 350, 250);
		contentPane = new JPanel();								//�������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//���ñ߿�
		setContentPane(contentPane); 							//Ӧ�����
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));		//���ò��ֹ�����
		JPanel panel1 = new JPanel();							//�������
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel1);
		JLabel label1 = new JLabel("��¼");						//����
		panel1.add(label1);
		JPanel panel2 = new JPanel();							//�������
		FlowLayout flowLayout2 = (FlowLayout) panel2.getLayout();
		flowLayout2.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel2);
		JLabel label2 = new JLabel("�û�����");
		panel2.add(label2);
		username = new JTextField();
		panel2.add(username);
		username.setColumns(18);
		JPanel panel3 = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) panel3.getLayout();
		flowLayout3.setAlignment(FlowLayout.CENTER);
		contentPane.add(panel3);
		JLabel label3 = new JLabel("��    �룺");
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
		JButton login = new JButton("��¼");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String uname = username.getText().trim();			//����û���
				String pswd = new String(password.getPassword());	//�������
				admin ad = new admin();							
				ad.setUserName(uname); 							//��װ�û���
				ad.setPassWord(pswd); 								//��װ����
				if(AdminDao.okAdmin(ad)) {						//����û���������ȷ
					AdminFrame rootclass = new AdminFrame();		//��������Ա��������
					rootclass.setVisible(true);
					Toolkit toolkit = rootclass.getToolkit();	//���Toolkit����
					Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
					//ʹ����Ļ����
					rootclass.setLocation((dm.width - rootclass.getWidth())/2, (dm.height - rootclass.getHeight())/2);
					dispose();
				}
			}
		});
		panel5.add(login);
	}
}
