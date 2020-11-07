package com.bean.classmate;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
 
public class DatabasetoExcel {
	
	private static final int[] colWidth={2000,2000,5000,5000,
			5000,5000,5000,5000};
	
	//�ļ�·��
	private static String outPutFile="."+File.separator+"user.xls";
	//���ݿ����Ӳ���
	private static String url="jdbc:mysql://localhost:3306/classmate_record";
	private static String user="root";
	private static String password="123456";

	public static void work() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//�������ݿ��ѯ����
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			String sql="select * from t_user";
			ps=conn.prepareStatement(sql);
			//��ȡ�����
			rs = ps.executeQuery();
			//���ڻ�ȡ�ֶε�������Ϣ,�����ֶ���
			ResultSetMetaData metaData = rs.getMetaData();
			//����workBook����
			HSSFWorkbook workBook=new HSSFWorkbook();
			//��workBook�����д���һ�ű��
			HSSFSheet sheet= workBook.createSheet("classmate");
			//����ÿһ�еĿ��
			for(int i=0;i<colWidth.length;i++){
				sheet.setColumnWidth(i, colWidth[i]);
			}
			//��Ԫ����ʽ����
			HSSFCellStyle cellStyle = workBook.createCellStyle();
			//�����ı�����
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			//������0��,��Ϊ���ı�ͷ
			HSSFRow row=sheet.createRow(0);
			HSSFCell cell=null;
			for(int i=0;i<colWidth.length;i++){
				cell=row.createCell(i);
				//��̬��ȡ�ֶ���
				cell.setCellValue(metaData.getColumnLabel(i+1));
				cell.setCellStyle(cellStyle);
			}
			int rowIndex=1;
			while(rs.next()){
				//ѭ������ѯ���������ݷ�װ������һ����
				row=sheet.createRow(rowIndex);
				for(int i=0;i<colWidth.length;i++){
					cell=row.createCell(i);
					cell.setCellValue(rs.getString(i+1));
					cell.setCellStyle(cellStyle);
				}
				rowIndex++;
			}
			FileOutputStream fos=new FileOutputStream(outPutFile);
			//��������ļ�д��Ӳ��
			workBook.write(fos);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

}