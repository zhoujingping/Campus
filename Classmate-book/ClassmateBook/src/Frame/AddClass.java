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
import model.Class1;

public class AddClass extends JFrame{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	
	private JTextField id = null;
	private JTextField school = null;
	private JTextField name = null;
	private JTextField username = null;
	private String gid;
	private int i;
	

	private static Class1 class1 = new Class1();
	
	
	
	public AddClass(){
		setTitle("��Ӱ༶");								//���ô������
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			//�����رհ�ť�ǹر�
		setSize(350, 400);
		contentPane = new JPanel();								//�������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//���ñ߿�
		setContentPane(contentPane); 							//Ӧ�����
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("�༶�ţ�");
		panel1.add(label1);
		id = new JTextField();
		panel1.add(id);
		id.setColumns(10);
		id.setBackground(Color.LIGHT_GRAY);
		id.setEditable(false);
		panel1.setBorder(new EmptyBorder(10, 23, 10, 20));
		
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("ѧУ��");
		panel2.add(label2);
		school = new JTextField();
		panel2.add(school);
		school.setColumns(10);
		panel2.setBorder(new EmptyBorder(10, 33, 10, 20));
		
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel("�༶����");
		panel3.add(label3);
		name = new JTextField();
		panel3.add(name);
		name.setColumns(10);
		panel3.setBorder(new EmptyBorder(10, 23, 10, 20));
		
		JPanel panel4 = new JPanel();
		JLabel label4 = new JLabel("�೤��");
		panel4.add(label4);
		username = new JTextField();
		panel4.add(username);
		username.setColumns(10);
		panel4.setBorder(new EmptyBorder(10, 33, 10, 20));
		
		
		JButton add = new JButton("���");
		JPanel panel9 = new JPanel();
		panel9.add(add);
		panel9.setBorder(new EmptyBorder(5, 33, 10, 20));
		
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(panel4);
		contentPane.add(panel9);
		
		System.out.println(AdminFrame.getnum());
		gid = String.valueOf(AdminFrame.getnum());
		System.out.println(gid);
		id.setText(gid);
		class1.setId(Integer.parseInt(gid));
		System.out.println(class1.getId());
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!school.getText().equals("")) {
					class1.setSchool(school.getText());
					System.out.println(school);
				}else {
					class1.setSchool(null);
				}
				if (!name.getText().equals("")) {
					class1.setName(name.getText());
				}else {
					class1.setName(null);
				}
				if (!username.getText().equals("")) {
					class1.setUsername(username.getText());
				}else {
					class1.setUsername(null);
				}
				AdminFrame.setnum(AdminFrame.getnum());
				i = ClassDao.addClass(class1);
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
				
				Vector v = new Vector();
				v.add(AddClass.getclass().getId());
				v.add(AddClass.getclass().getSchool());
				v.add(AddClass.getclass().getName());
				v.add(AddClass.getclass().getUsername());
				AdminFrame.dtm.addRow(v);
				
				dispose();
			}
		});
		
		
	}
	public static Class1 getclass() {
		return class1;
	}
	
}


