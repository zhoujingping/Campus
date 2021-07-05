package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.information;
import model.information;

public class InformationDao extends Dao{
private static int id = 0;
	
	public static int getid() {
		return id;
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	
	public static information getInformation(int id){

		information information = new information();
		information.setId(id);
		String sql = "select * from information where id = ?";
		try {
			conn = Dao.getConn();					//��ȡ���ݿ�����
			//����PrepareStatement���󣬲�����SQL���
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);					//Ϊ������ֵ
			ResultSet rs = ps.executeQuery();		//ִ��SQL��䣬��ò�ѯ�����
			if (rs.next() && rs.getRow() > 0) {	
				information.setName(rs.getString("name"));
				information.setAddress(rs.getString("address"));
				information.setPhone(rs.getString("phone"));
				information.setWchat(rs.getString("wchat"));
				information.setEmail(rs.getString("email"));
				information.setQQ(rs.getString("QQ"));
				information.setClassId(rs.getInt("classid"));
				information.setMessage(rs.getString("message"));
			}else {
				JOptionPane.showMessageDialog(null, "��ͬѧ������");
				information.setId(0);
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

		return information;
	}
	
	/**
	 * ��ѯȫ��
	 * @return
	 */
	public static java.util.List<information> getAllInformation(int no){
		java.util.List<information> list = new ArrayList<information>();
		try {
			getConn();
			stmt = conn.createStatement();
			String sql = "select * from information where classid =? ";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, no);					//Ϊ������ֵ
			rs = pstmt.executeQuery();
			while(rs.next()) {
				information item = new information();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setAddress(rs.getString("address"));
				item.setPhone(rs.getString("phone"));
				item.setWchat(rs.getString("wchat"));
				item.setEmail(rs.getString("email"));
				item.setQQ(rs.getString("QQ"));
				item.setClassId(rs.getInt("classid"));
				item.setMessage(rs.getString("message"));
				
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
	public static java.util.List<information> getAInformation(){
		java.util.List<information> list = new ArrayList<information>();
		try {
			getConn();
			stmt = conn.createStatement();
			String sql = "select * from information";
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				information item = new information();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setAddress(rs.getString("address"));
				item.setPhone(rs.getString("phone"));
				item.setWchat(rs.getString("wchat"));
				item.setEmail(rs.getString("email"));
				item.setQQ(rs.getString("QQ"));
				item.setClassId(rs.getInt("classid"));
				item.setMessage(rs.getString("message"));
				
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
	public static int addinformation(information item) {
		int iRow = 0;
		try {
			getConn();
			String sql ="insert into information(id,name,address,phone,wchat,email,qq,classid,message) values (?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item.getId());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getAddress());
			pstmt.setString(4, item.getPhone());
			pstmt.setString(5, item.getWchat());
			pstmt.setString(6, item.getEmail());
			pstmt.setString(7, item.getQQ());
			pstmt.setInt(8, item.getClassId());
			pstmt.setString(9, item.getMessage());
		
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
	public static int editinformation(information item) {
		int iRow = 0;
		try {
			getConn();
			String sql = "update information set name=?,address=?,phone=?,wchat=?,email=?,qq=?,classid=?,message=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getAddress());
			pstmt.setString(3, item.getPhone());
			pstmt.setString(4, item.getWchat());
			pstmt.setString(5, item.getEmail());
			pstmt.setString(6, item.getQQ());
			pstmt.setInt(7, item.getClassId());
			pstmt.setString(8, item.getMessage());
			pstmt.setInt(9, item.getId());
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
	public static int delinformation(int id) {
		int iRow = 0;
		try {
			getConn();
			String sql = "delete from information where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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