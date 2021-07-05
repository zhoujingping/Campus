package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Class1;


public class ClassDao extends Dao{
	/**
	 * ��ѯ����
	 * @return
	 */
	
	public static Class1 getClass(int cno){

		Class1 class1 = new Class1();
		class1.setId(cno);
		String sql = "select * from class where id = ?";
		try {
			conn = Dao.getConn();					//��ȡ���ݿ�����
			//����PrepareStatement���󣬲�����SQL���
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);					//Ϊ������ֵ
			ResultSet rs = ps.executeQuery();		//ִ��SQL��䣬��ò�ѯ�����
			if (rs.next() && rs.getRow() > 0) {	
				class1.setSchool(rs.getString("School"));
				class1.setName(rs.getString("Name"));
				class1.setUsername("Username");
			}else {
				JOptionPane.showMessageDialog(null, "id������");
				class1.setId(0);
			}
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n"+e.getMessage());
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}

		return class1;
	}
	
	/**
	 * ��ѯȫ��
	 * @return
	 */
	public static java.util.List<Class1> getAllClass(){
		java.util.List<Class1> list = new ArrayList<Class1>();
		try {
			getConn();
			stmt = conn.createStatement();
			String sql = "select * from class";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Class1 item = new Class1();
				item.setId(rs.getInt("Id"));
				item.setSchool(rs.getString("School"));
				item.setName(rs.getString("Name"));
				item.setUsername(rs.getString("UserName"));
				list.add(item);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	/**
	 * ���
	 */
	public static int addClass(Class1 item) {
		int iRow = 0;
		try {
			getConn();
			String sql ="insert into class(id,school,name,username) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item.getId());
			pstmt.setString(2, item.getSchool());
			pstmt.setString(3, item.getName());
			pstmt.setString(4, item.getUsername());
		
			iRow = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return iRow;
	}
	
	/**
	 * �޸�
	 */
	public static int editClass(Class1 item) {
		int iRow = 0;
		try {
			getConn();
			String sql = "update class set school=?,name=?,username=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getSchool());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getUsername());
			pstmt.setInt(4, item.getId());
			iRow = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return iRow;
	}
	
	
	/**
	 * ɾ��
	 */
	public static int delClass(String id) {
		int iRow = 0;
		try {
			getConn();
			String sql = "delete from Class where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			iRow = pstmt.executeUpdate();
			System.out.println("��ɾ��");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return iRow;
	}
}
