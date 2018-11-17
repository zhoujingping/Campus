package db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBconnection {
 static Connection conn=null;
 static String driver="com.mysql.jdbc.Driver"; 
 static String url="jdbc:mysql://localhost:3306/classmate_record"; 
 static String user="root"; 
 static String password="123456";
 public static Connection getConnector()
 {
 try { 
     Class.forName(driver); 
     //System.out.println("驱动程序加载成功"); 
 } catch (ClassNotFoundException e) { 
     e.printStackTrace(); 
 } 
 try { 
     conn=(Connection) DriverManager.getConnection(url, user, password); 
//     if (conn!=null) { 
//         System.out.println("连接数据库成功"); 
//     } 
 } catch (SQLException e) { 
     System.out.println("链接数据库失败: "+e.getMessage()); 
 }
     return conn;	
 }	
 
}

