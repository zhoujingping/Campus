package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Vector;

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

import Dao.InformationDao;
import excel.excelOut;
import model.information;

public class InformationFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField id = null;
	private JTextField sid = null;
	private JTextField name = null;
	private JTextField address = null;
	private JTextField wchat = null;
	private JTextField message = null;
	private JTextField email = null;
	private JTextField phone = null;
	private JTextField qq = null;
	private JTextField classid = null;
	private JPanel contentPane;
	private int i = 0;
	private int j = 0;
	private int row = -1;
	private String gid;
	private String gname;
	private String gaddress;
	private String gwchat;
	private String gemail;
	private String gphone;
	private String gqq;
	private String gclassid;
	private String gsid;
	private String gmessage;
	public static DefaultTableModel dtm;
	
	private static int num = 0;
	public static int getnum() {
		return num;
	}
	
	public static void setnum(int num) {
		num += 1;
	}
	
	public InformationFrame(int no) {
		setTitle("同学录管理");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			//单击关闭按钮是关闭
		setSize(800, 600);
		setVisible(true);
		
		JTable table = new JTable();
		String[] tableHeads = new String[]{"ID","姓名","家庭地址","联系电话","微信","邮箱","QQ","班级ID","个性语言"};
		dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		ArrayList<information> list;
		if (no == 0) {
			list = (ArrayList<information>) InformationDao.getAInformation();
		}else {
			list = (ArrayList<information>) InformationDao.getAllInformation(no);
		}
		for(j = 0; j < list.size(); j++) {
			Vector v = new Vector();
			v.add(list.get(j).getId());
			v.add(list.get(j).getName());
			v.add(list.get(j).getAddress());
			v.add(list.get(j).getWchat());
			v.add(list.get(j).getEmail());
			v.add(list.get(j).getQQ());
			v.add(list.get(j).getPhone());
			v.add(list.get(j).getClassId());
			v.add(list.get(j).getMessage());
			  
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
		
		contentPane = new JPanel();								//创建面板
		setContentPane(contentPane); 
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("ID：");
		panel1.add(label1);
		id = new JTextField();
		panel1.add(id);
		id.setColumns(10);
		id.setBackground(Color.LIGHT_GRAY);
		id.setEditable(false);
		JLabel label2 = new JLabel("姓名：");
		panel1.add(label2);
		name = new JTextField();
		panel1.add(name);
		name.setColumns(10);
		JLabel label3 = new JLabel("家庭住址：");
		panel1.add(label3);
		address = new JTextField();
		panel1.add(address);
		address.setColumns(10);
		JLabel label4 = new JLabel("电话：");
		panel1.add(label4);
		wchat = new JTextField();
		panel1.add(wchat);
		wchat.setColumns(10);
		
		JPanel panel2 = new JPanel();
		JLabel label6 = new JLabel("微信：");
		panel2.add(label6);
		qq = new JTextField();
		panel2.add(qq);
		qq.setColumns(8);
		label6.setBorder(new EmptyBorder(0, 13, 0, 0));
		JLabel label5 = new JLabel("邮箱：");
		panel2.add(label5);
		email = new JTextField();
		panel2.add(email);
		email.setColumns(8);
		JLabel label7 = new JLabel("QQ：");
		panel2.add(label7);
		phone = new JTextField();
		panel2.add(phone);
		phone.setColumns(8);
		JLabel label8 = new JLabel("班级号：");
		panel2.add(label8);
		classid = new JTextField();
		panel2.add(classid);
		classid.setColumns(8);
		JLabel label19 = new JLabel("个性语言：");
		panel2.add(label19);
		message = new JTextField();
		panel2.add(message);
		message.setColumns(8);
		
		JPanel panel3 = new JPanel();
		JButton update = new JButton("修改");
		JPanel panel4 = new JPanel();
		panel4.add(update);
		panel4.setBorder(new EmptyBorder(0, 0, 0, 20));
		panel3.add(panel4);
		JButton add = new JButton("增加");
		JPanel panel5 = new JPanel();
		panel5.add(add);
		panel5.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel5);
		JButton delete = new JButton("删除");
		JPanel panel6 = new JPanel();
		panel6.add(delete);
		panel6.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel6);
		JButton clear = new JButton("清空");
		JPanel panel8 = new JPanel();
		panel8.add(clear);
		panel8.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel3.add(panel8);
		
	//	panel3.add(panel7);

		JPanel panel7 = new JPanel();
		JLabel label9 = new JLabel("ID：");
		panel7.add(label9);
		sid = new JTextField();

		sid.setColumns(10);
		panel7.add(sid);
		
		JButton select = new JButton("查找");
		panel7.add(select);
		panel7.setBorder(new EmptyBorder(0, 20, 0, 0));
		

		
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(panel);
		contentPane.add(panel7);
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gid = id.getText();
				System.out.println(gid);
				if (gid.equals("")) {
					JOptionPane.showMessageDialog(null, "删除失败");
				} else {
					i = InformationDao.delinformation(Integer.parseInt(gid));
					dtm.removeRow(row);
					JOptionPane.showMessageDialog(null, "删除成功");
					if (!id.getText().equals("")) {
						id.setText("");
					}
					if (!name.getText().equals("")) {
						name.setText("");
					}
					if (!address.getText().equals("")) {
						address.setText("");
					}
					if (!wchat.getText().equals("")) {
						wchat.setText("");
					}
					if (!email.getText().equals("")) {
						email.setText("");
					}
					if (!phone.getText().equals("")) {
						phone.setText("");
					}
					if (!qq.getText().equals("")) {
						qq.setText("");
					}
					if (!classid.getText().equals("")) {
						classid.setText("");
					}

					if (!message.getText().equals("")) {
						message.setText("");
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
				if (!name.getText().equals("")) {
					name.setText("");
				}
				if (!address.getText().equals("")) {
					address.setText("");
				}
				if (!wchat.getText().equals("")) {
					wchat.setText("");
				}
				if (!email.getText().equals("")) {
					email.setText("");
				}
				if (!phone.getText().equals("")) {
					phone.setText("");
				}
				if (!qq.getText().equals("")) {
					qq.setText("");
				}
				if (!classid.getText().equals("")) {
					classid.setText("");
				}

				if (!message.getText().equals("")) {
					message.setText("");
				}
				dtm.setRowCount(0);
				ArrayList<information> list = (ArrayList<information>) InformationDao.getAllInformation(no);
				for(j = 0; j < list.size(); j++) {
					  Vector v = new Vector();
					  v.add(list.get(j).getId());
					  v.add(list.get(j).getName());
					  v.add(list.get(j).getAddress());
					  v.add(list.get(j).getWchat());
					  v.add(list.get(j).getEmail());
					  v.add(list.get(j).getQQ());
					  v.add(list.get(j).getPhone());
					  v.add(list.get(j).getClassId());
					  v.add(list.get(j).getMessage());
					  
					  if (list.get(j).getId() > num) {
						  num = list.get(j).getId();
					  }
					  
					  dtm.addRow(v);
				  }
				  num += 1;
				
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				information information = new information();
				if (!id.getText().equals("")) {
					information.setId(Integer.parseInt(id.getText()));;
				}else {
					information.setId(0);
				}
				if (!name.getText().equals("")) {
					information.setName(name.getText());
				}else {
					information.setName(null);
				}
				if (!address.getText().equals("")) {
					information.setAddress(address.getText());
				}else {
					information.setAddress(null);
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
				if (!phone.getText().equals("")) {
					information.setPhone(phone.getText());
				}else {
					information.setPhone(null);
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
				InformationDao.editinformation(information);
				JOptionPane.showMessageDialog(null, "修改成功");
				if (!name.getText().equals("")) {
					dtm.setValueAt(name.getText(), row, 1);
				}
				if (!address.getText().equals("")) {
					dtm.setValueAt(address.getText(), row, 2);
				}
				if (!wchat.getText().equals("")) {
					dtm.setValueAt(phone.getText(), row, 3);
				}
				if (!email.getText().equals("")) {
					dtm.setValueAt(wchat.getText(), row, 4);
				}
				if (!phone.getText().equals("")) {
					dtm.setValueAt(email.getText(), row, 6);
				}
				if (!qq.getText().equals("")) {
					dtm.setValueAt(qq.getText(), row, 5);
				}
				if (!classid.getText().equals("")) {
					dtm.setValueAt(classid.getText(), row, 7);
				}
				if (!message.getText().equals("")) {
					dtm.setValueAt(message.getText(), row, 8);
				}
				
			}
		});
	
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddInformation addInformation = new AddInformation();		//创建管理员操作界面
				addInformation.setVisible(true);
				Toolkit toolkit = addInformation.getToolkit();	//获得Toolkit对象
				Dimension dm = toolkit.getScreenSize();		//获得屏幕的大小
				//使主屏幕居中
				addInformation.setLocation((dm.width - addInformation.getWidth())/2, (dm.height - addInformation.getHeight())/2);
				
			}
		});
		
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "id不能为空");
				}else {
					dtm.setRowCount(0);
					gsid = sid.getText().trim();
					information information = new information();
					
					dtm.setRowCount(0);
					
					  information = InformationDao.getInformation(Integer.parseInt(gsid));
				  
						  Vector v = new Vector();
						  v.add(information.getId());
						  v.add(information.getName());
						  v.add(information.getAddress());
						  v.add(information.getPhone());
						  v.add(information.getWchat());
						  v.add(information.getEmail());
						  v.add(information.getQQ());
						  v.add(information.getClassId());
						  v.add(information.getMessage());
						  dtm.addRow(v);
					
				}
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			  /**
			   * 鼠标单击事件
			   * @param e 事件源事件
			   */
			  public void mouseClicked(java.awt.event.MouseEvent e) {

				  if (table.getValueAt(table.getSelectedRow(), 0) != null) {
					  row=table.getSelectedRow();
					  if (table.getValueAt(row, 0) != null) {
						  gid = table.getValueAt(row, 0).toString();
					  }
					  if (table.getValueAt(row, 1) != null) {
						  gname = table.getValueAt(row, 1).toString();
					  }
					  if (table.getValueAt(row, 2) != null) {
						  gaddress = table.getValueAt(row, 2).toString();
					  }
					  if (table.getValueAt(row, 3) != null) {
						  gphone = table.getValueAt(row, 3).toString();
					  }
					  if (table.getValueAt(row, 4) != null) {
						  gwchat = table.getValueAt(row, 4).toString();
					  }
					  if (table.getValueAt(row, 5) != null) {
						  gemail =  table.getValueAt(row, 5).toString();
					  }
					  if (table.getValueAt(row, 6) != null) {
						  gqq = table.getValueAt(row, 6).toString();		
					  }
					  if (table.getValueAt(row, 7) != null) {
						  gclassid = table.getValueAt(row, 7).toString();
					  }
					  if (table.getValueAt(row, 8) != null) {
						  gmessage = table.getValueAt(row, 8).toString();
					  }
					  id.setText(gid);
					  name.setText(gname);
					  address.setText(gaddress);
					  wchat.setText(gwchat);
					  email.setText(gemail);
					  qq.setText(gqq);
					  phone.setText(gphone);
					  classid.setText(gclassid);
					  message.setText(gmessage);
					  System.out.println(gphone);
				  }
				  
			  }
		});
		
	}

}
