package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.ClassDao;
import model.Class1;
import Frame.AddClass;
import excel.excelOut;

public class AdminFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField id = null;
	private JTextField school = null;
	private JTextField name = null;
	private JTextField username = null;
	private JTextField sid = null;
	private int i = 0;
	private int j = 0;
	private int row = -1;
	private String gid;

	private String gsid;
	private String gschool;
	private String gname;
	private String gusername;
	public static DefaultTableModel dtm;
	
	private static int num = 0;
	public static int getnum() {
		return num;
	}
	
	public static void setnum(int num) {
		num += 1;
	}
	
	public AdminFrame() {
		setTitle("ͬѧ¼����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			//�����رհ�ť�ǹر�
		setSize(800, 600);
		setVisible(true);
		
		JTable table = new JTable();
		String[] tableHeads = new String[]{"�༶��","ѧУ","�༶��","�೤"};
		dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		ArrayList<Class1> list = (ArrayList<Class1>) ClassDao.getAllClass();
		  
		for(j = 0; j < list.size(); j++) {
			Vector v = new Vector();
			v.add(list.get(j).getId());
			v.add(list.get(j).getSchool());
			v.add(list.get(j).getName());
			v.add(list.get(j).getUsername());
			  
			if (list.get(j).getId() > num) {
				num = list.get(j).getId();
			}
			  
			dtm.addRow(v);
		}
		  
		num += 1; 
		  
		table.setPreferredScrollableViewportSize(new Dimension(760,350));
		  
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.getTableHeader().setReorderingAllowed(false);
		  
		  
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(700, 500);
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		
		JPanel contentPane = new JPanel();								//�������
		setContentPane(contentPane); 
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("�༶�ţ�");
		panel1.add(label1);
		id = new JTextField();
		panel1.add(id);
		id.setColumns(10);
		id.setBackground(Color.LIGHT_GRAY);
		id.setEditable(false);
		JLabel label2 = new JLabel("ѧУ��");
		panel1.add(label2);
		school= new JTextField();
		panel1.add(school);
		school.setColumns(10);
		JLabel label3 = new JLabel("�༶����");
		panel1.add(label3);
		name = new JTextField();
		panel1.add(name);
		name.setColumns(10);
		JLabel label4 = new JLabel("�೤��");
		panel1.add(label4);
		username = new JTextField();
		panel1.add(username);
		username.setColumns(10);
		
		JPanel panel3 = new JPanel();
		JButton update = new JButton("�޸�");
		JPanel panel4 = new JPanel();
		panel4.add(update);
		panel4.setBorder(new EmptyBorder(0, 0, 0, 20));
		panel3.add(panel4);
		JButton add = new JButton("����");
		JPanel panel5 = new JPanel();
		panel5.add(add);
		panel5.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel5);
		JButton delete = new JButton("ɾ��");
		JPanel panel6 = new JPanel();
		panel6.add(delete);
		panel6.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel6);
		
		JButton clear = new JButton("���");
		JPanel panel8 = new JPanel();
		panel8.add(clear);
		panel8.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel8);

		
	//	panel3.add(panel7);

		JPanel panel7 = new JPanel();
		JLabel label9 = new JLabel("�༶�ţ�");
		panel7.add(label9);
		sid = new JTextField();

		sid.setColumns(10);
		panel7.add(sid);
		
		JButton select = new JButton("����");
		panel7.add(select);
		panel7.setBorder(new EmptyBorder(0, 20, 0, 0));
		

		JButton detail = new JButton("�鿴ͨѶ¼");
		panel7.add(detail);
		panel7.setBorder(new EmptyBorder(0, 20, 0, 0));
		

		JButton out = new JButton("�����ð�ͨѶ¼");
		panel7.add(out);
		panel7.setBorder(new EmptyBorder(0, 20, 0, 0));
		
		contentPane.add(panel1);
		contentPane.add(panel3);
		contentPane.add(panel);
		contentPane.add(panel7);
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excelOut.ExcelOut(gname, Integer.parseInt(gid));
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gid = id.getText();
				if (gid.equals("")) {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				} else {
					i = ClassDao.delClass(gid);
					dtm.removeRow(row);
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					if (!id.getText().equals("")) {
						id.setText("");
					}
					if (!school.getText().equals("")) {
						school.setText("");
					}
					if (!name.getText().equals("")) {
						name.setText("");
					}
					if (!username.getText().equals("")) {
						username.setText("");
					}
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!id.getText().equals("")) {
					id.setText("");
				}
				if (!sid.getText().equals("")) {
					sid.setText("");
				}
				if (!school.getText().equals("")) {
					school.setText("");
				}
				if (!name.getText().equals("")) {
					name.setText("");
				}
				if (!username.getText().equals("")) {
					username.setText("");
				}
				dtm.setRowCount(0);
				ArrayList<Class1> list = (ArrayList<Class1>) ClassDao.getAllClass();
				for(j = 0; j < list.size(); j++) {
					  Vector v = new Vector();
					  v.add(list.get(j).getId());
					  v.add(list.get(j).getSchool());
					  v.add(list.get(j).getName());
					  v.add(list.get(j).getUsername());
					  
					  if (list.get(j).getId() > num) {
						  num = list.get(j).getId();
					  }
					  
					  dtm.addRow(v);
				  }
				  num += 1;
				
			}
		});
		
	
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddClass addClass = new AddClass();		//��������Ա��������
				addClass.setVisible(true);
				Toolkit toolkit = addClass.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				addClass.setLocation((dm.width - addClass.getWidth())/2, (dm.height - addClass.getHeight())/2);
				
			}
		});
		
		detail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InformationFrame informationFrame = new InformationFrame(Integer.parseInt(id.getText()));		//��������Ա��������
				informationFrame.setVisible(true);
				Toolkit toolkit = informationFrame.getToolkit();	//���Toolkit����
				Dimension dm = toolkit.getScreenSize();		//�����Ļ�Ĵ�С
				//ʹ����Ļ����
				informationFrame.setLocation((dm.width - informationFrame.getWidth())/2, (dm.height - informationFrame.getHeight())/2);
			}
		});
		
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "id����Ϊ��");
				}else {
					dtm.setRowCount(0);
					gsid = sid.getText().trim();
					Class1 class1 = new Class1();
					
					dtm.setRowCount(0);
					
					class1 = ClassDao.getClass(Integer.parseInt(gsid));
					Vector v = new Vector();
					v.add(class1.getId());
					v.add(class1.getSchool());
					v.add(class1.getName());
					v.add(class1.getUsername());
				  
					dtm.addRow(v);
					
				}
				
			}
		});

		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Class1 class1 = new Class1();
				if (!id.getText().equals("")) {
					class1.setId(Integer.parseInt(id.getText()));
				}else {
					class1.setId(0);
				}
				if (!school.getText().equals("")) {
					class1.setSchool(school.getText());
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
				ClassDao.editClass(class1);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				if (!school.getText().equals("")) {
					dtm.setValueAt(school.getText(), row, 1);
				}
				if (!name.getText().equals("")) {
					dtm.setValueAt(name.getText(), row, 2);
				}
				if (!username.getText().equals("")) {
					dtm.setValueAt(username.getText(), row, 3);
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			  /**
			   * ��굥���¼�
			   * @param e �¼�Դ�¼�
			   */
			  public void mouseClicked(java.awt.event.MouseEvent e) {

				  if (table.getValueAt(table.getSelectedRow(), 0) != null) {
					  row=table.getSelectedRow();
					  if (table.getValueAt(row, 0) != null) {
						  gid = table.getValueAt(row, 0).toString();
					  }
					  if (table.getValueAt(row, 1) != null) {
						  gschool = table.getValueAt(row, 1).toString();
					  }
					  if (table.getValueAt(row, 2) != null) {
						  gname = table.getValueAt(row, 2).toString();
					  }
					  if (table.getValueAt(row, 3) != null) {
						  gusername = table.getValueAt(row, 3).toString();
					  }
					  id.setText(gid);
					  school.setText(gschool);
					  name.setText(gname);
					  username.setText(gusername);
				  }
				 
			  }
		});
		
		
	}
	
}
