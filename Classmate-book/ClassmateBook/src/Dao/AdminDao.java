package Dao;

import model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AdminDao extends Dao {
    public static boolean okAdmin(admin ad){
        Connection conn = null;
        String username = ad.getUserName();
        String psd = ad.getPassWord();
        conn = Dao.getConn();
        try {
            PreparedStatement pstmt = conn.prepareStatement("select Password from admin where username = ? ");
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getRow() > 0) {		//��ѯ���û���Ϣ
				String password = rs.getString(1).trim();	//�������
				if (password.equals(psd)) {
					return true;					//������ȷ����true
				} else {
					JOptionPane.showMessageDialog(null, "���벻��ȷ");
					System.out.println("���벻��ȷ");
					return false;					//������󷵻�false
				}
			} else {
				JOptionPane.showMessageDialog(null, "�û���������");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "���ݿ��쳣��\n"+e.getMessage());
			return false;
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
    }
}
