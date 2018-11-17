package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Information;
import model.information;

public class InformationDao extends Dao{
	
	private static String dno = "000000";
	
	public static String getdno() {
		return dno;
	}
	
	/**
	 * 判断用户名和密码的方法
	 * 
	 * @param Information
	 * 实例类Information的实例
	 */
	public static boolean okInformation(information Information) {
		Connection conn = null;
		i
	}
	
	/**
	 * 查询单个
	 * @return
	 */
	
	public static information getInformation(int id){

		information Information = new information();
		Information.setId(id);
			String sql = "select * from Information where id = ?";
			try {
				conn = Dao.getConn();					//获取数据库连接
				//创建PrepareStatement对象，并传递SQL语句
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);					//为参数赋值
				ResultSet rs = ps.executeQuery();		//执行SQL语句，获得查询结果集
				if (rs.next() && rs.getRow() > 0) {	
					Information.setName(rs.getString("name"));
					Information.setAddress(rs.getString("address"));
					Information.setEmail(rs.getString("email"));
					Information.setQQ(rs.getString("qq"));
					Information.setPhone(rs.getString("phone"));
					Information.setClassId(rs.getInt("classid"));
				}else {
					JOptionPane.showMessageDialog(null, "医生工号不存在");
					Information.setid(null);
				}
			}catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "数据库异常！\n"+e.getMessage());
				
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

			return Information;
		}
		
		/**
		 * 查询全部
		 * @return
		 */
		public static java.util.List<Information> getAllInformation(){
			java.util.List<Information> list = new ArrayList<Information>();
			try {
				getConn();
				stmt = conn.createStatement();
				String sql = "select * from Information";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Information item = new Information();
					item.setid(rs.getString("id"));
					item.setname(rs.getString("name"));
					item.setaddress(rs.getString("address"));
					item.setdage(rs.getInt("dage"));
					item.setpsd(rs.getString("psd"));
					item.setemail(rs.getInt("email"));
					item.setqq(rs.getString("qq"));
					item.setphone(rs.getString("phone"));
					item.setclassid(rs.getString("classid"));
					
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
		 * 添加
		 */
		public static int addInformation(Information item) {
			int iRow = 0;
			try {
				getConn();
				String sql ="insert into Information(id,name,dage,address,email,qq,phone,psd,classid) values (?,?,?,?,?,?,?,?,?)";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, item.getid());
				pStmt.setString(2, item.getname());
				pStmt.setInt(3, item.getdage());
				pStmt.setString(4, item.getaddress());
				pStmt.setInt(5, item.getemail());
				pStmt.setString(6, item.getqq());
				pStmt.setString(7, item.getphone());
				pStmt.setString(8, item.getpsd());
				pStmt.setString(9, item.getclassid());
			
				iRow = pStmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll();
			}
			return iRow;
		}
		
		/**
		 * 修改
		 */
		public static int editInformation(Information item) {
			int iRow = 0;
			try {
				getConn();
				String sql = "update Information set dage=?,name=?,address=?,email=?,qq=?,phone=?,classid=? where id=?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, item.getdage());
				pStmt.setString(2, item.getname());
				pStmt.setString(3, item.getaddress());
				pStmt.setInt(4, item.getemail());
				pStmt.setString(5, item.getqq());
				pStmt.setString(6, item.getphone());
				pStmt.setString(7, item.getclassid());
				pStmt.setString(8, item.getid());
				
				iRow = pStmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll();
			}
			return iRow;
		}
		
		/**
		 * 修改
		 */
		public static int editpsd(Information item) {
			int iRow = 0;
			try {
				getConn();
				String sql = "update Information set psd=? where id=?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, item.getpsd());
				pStmt.setString(2, item.getid());
				
				iRow = pStmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll();
			}
			return iRow;
		}
		
		
		/**
		 * 删除
		 */
		public static int delInformation(String id) {
			int iRow = 0;
			try {
				getConn();
				String sql = "delete from Information where id = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, id);
				
				iRow = pStmt.executeUpdate();
				System.out.println("已删除");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll();
			}
			return iRow;
		}
	}

