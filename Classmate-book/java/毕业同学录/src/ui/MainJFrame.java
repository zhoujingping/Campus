package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import util.DBUtil;
import util.ToExcel;

public class MainJFrame extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;

    private JScrollPane jscrolpanel;
    private JTable table;
    private DefaultTableModel model;
    private String[] col= {"学号","姓名","家庭住址","电话","微信","邮箱","QQ","个性语言"};
    String[] tcol={"snumber","sname","saddress","sphone","sweixing","semail","sqq","sself"};

    private String[][] data;
    private JButton button_insert;
    private JButton button_select;
    private JButton button_update;
    private JButton button_delete;

    private JButton button_excel;
    public MainJFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("毕业同学录");
        this.setSize(1020, 820);
        this.setLocationRelativeTo(null);

        button_insert=new JButton("添加");
        button_delete=new JButton("删除");
        button_update=new JButton("更改");
        button_select=new JButton("查询");
        button_excel=new JButton("导出到excel");

        button_insert.setBounds(820, 20, 120, 60);
        button_insert.addActionListener(this);

        button_delete.setBounds(820, 90, 120, 60);
        button_delete.addActionListener(this);

        button_update.setBounds(820, 160, 120, 60);
        button_update.addActionListener(this);
        button_select.setBounds(820, 230, 120, 60);
        button_select.addActionListener(this);

        button_excel.setBounds(820, 300, 120, 60);
        button_excel.addActionListener(this);
        this.getContentPane().add(button_insert);
        this.getContentPane().add(button_delete);
        this.getContentPane().add(button_update);
        this.getContentPane().add(button_select);
        this.getContentPane().add(button_excel);

        init();
        this.setVisible(true);
    }

    public void initData() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
           // Connection connection= DBUtil.getDBConnect();
            Connection connection1=DBUtil.getDBConnect();
            //Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8&useSSL=false","root","123456");
            String sql = "select * from student";
            PreparedStatement pstm = (PreparedStatement) connection1.prepareStatement(sql);
            int count = 0;
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                count++;
            }
            data=new String[count][8];
            rs=pstm.executeQuery();
            count=0;
            while(rs.next()) {
                data[count][0]=rs.getString("snumber");
                data[count][1]=rs.getString("sname");
                data[count][2]=rs.getString("saddress");
                data[count][3]=rs.getString("sphone");
                data[count][4]=rs.getString("sweixing");
                data[count][5]=rs.getString("semail");
                data[count][6]=rs.getString("sqq");
                data[count][7]=rs.getString("sself");
                count++;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void init() {
        initData();

        model=new DefaultTableModel(data,col);
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row=e.getFirstRow();
                int col=e.getColumn();
                if(col==0){
                    JOptionPane.showMessageDialog(null,"学号不可更改");
                }else if(col>0){
                    String s=(String)model.getValueAt(row,col);
                    update(tcol[col],s,data[row][0]);
                }
            }
        });
        table=new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700,600));
        jscrolpanel=new JScrollPane(table);
        jscrolpanel.setBounds(0, 0, 800, 700);
        this.getContentPane().add(jscrolpanel);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MainJFrame main=new MainJFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        switch(e.getActionCommand()) {
            case "添加":
                InsertJFrame frame = new InsertJFrame(this);
                break;
            case "导出到excel":
                ToExcel.toExcel(data);
                JOptionPane.showMessageDialog(null,"导出成功,请在项目文件夹查看");
                break;
            case "删除":
                if(table.getSelectedRow()<0){
                    JOptionPane.showMessageDialog(null,"请选择一行数据后点击删除");
                    System.out.print(table.getSelectedRow());
                }else{
                    if(delete(data[table.getSelectedRow()][0])){
                        model.removeRow(table.getSelectedRow());
                    }
                }
                break;
            case "更改":
                JOptionPane.showMessageDialog(null,"请双击需要更改的值");
                break;
            case "查询":
                updateTable();
                break;
        }
    }

    public boolean delete(String number){
        Connection connection=DBUtil.getDBConnect();
        boolean ok=false;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("delete from student where snumber=?");
            preparedStatement.setNString(1,number);
            preparedStatement.execute();
            ok=true;
            connection.close();
            preparedStatement.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"删除失败");
        }
        return ok;
    }

    public void updateTable(){
        initData();
        model.setDataVector(data,col);
        table.updateUI();
    }

    public boolean update(String object,String value,String number){
        Connection connection=DBUtil.getDBConnect();
        boolean os=false;
        try{
            String sql="update student set "+object+"='"+value+"' where snumber='"+number+"'";
            PreparedStatement p=connection.prepareStatement(sql);
            p.execute();
            os=true;
            connection.close();
            p.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"错误："+e.getMessage());
        }
        return os;
    }
}
