package txl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

import javax.xml.crypto.Data;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.omg.CORBA.PRIVATE_MEMBER;

public class getExcel 
{
	public static void main(String[] args) throws IOException
	{
		String table[][]={
					{"����","��ͥסַ","�绰","΢��","����","QQ","��������"},
					{"zhangSan","fuZhou","13110","weixin123","123@qq.com","123","��������cool"}
				};
		//����Excel������
		HSSFWorkbook workbook=new HSSFWorkbook();
		//����һ��������
		HSSFSheet sheet=workbook.createSheet("sheet2");
		//������һ��
		HSSFRow row=null;	//0��
		HSSFCell cell=null;
		//�������
		for(int i=0;i<table.length;i++)//��
		{
			row=sheet.createRow(i);	
			for(int j=0;j<table[0].length;j++)//lie
			{
				cell=row.createCell(j);
				cell.setCellValue(table[i][j]);
			}
		}
		//����һ���ļ�,��Excel���ݴ���
		String filePath="d:\\workbook.xls";
		FileOutputStream output=new FileOutputStream(filePath);
		workbook.write(output);
		output.flush();
	}
}





