package com.bean.classmate;

import java.sql.Connection;
import java.sql.DriverManager;

public class connector {
	public static Connection getconn()
	{
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //����JDBC���� 
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test ;characterEncoding=utf8;useUnicode=true"; //���ӷ����������ݿ�sample 
		String userName = "sa"; //Ĭ���û��� 
		String userPwd = "123456"; //���� 
		Connection dbConn = null;
		try { 
		Class.forName(driverName); 
		dbConn = DriverManager.getConnection(dbURL, userName, userPwd); 
		System.out.println( "Connection Successful! "); //������ӳɹ� ����̨���Connection Successful!
		} 
		catch (Exception e) { 
		e.printStackTrace(); 
		} 
		finally
		{
		return dbConn;	
		}
	}
}
