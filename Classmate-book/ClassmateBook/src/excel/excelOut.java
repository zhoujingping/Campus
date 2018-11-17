package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import Dao.InformationDao;
import model.information;

public class excelOut {
	
	public static void ExcelOut(String name,int no) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(name);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(name);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
		HSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("ID");
		row2.createCell(1).setCellValue("姓名");
		row2.createCell(2).setCellValue("家庭地址");
		row2.createCell(3).setCellValue("电话");
		row2.createCell(4).setCellValue("微信");
		row2.createCell(5).setCellValue("邮箱");
		row2.createCell(6).setCellValue("QQ");
		row2.createCell(7).setCellValue("班级号");
		row2.createCell(8).setCellValue("个性语言");
		ArrayList<information> list;
		if (no == 0) {
			list = (ArrayList<information>) InformationDao.getAInformation();
		}else {
			list = (ArrayList<information>) InformationDao.getAllInformation(no);
		}
		for(int j = 0; j < list.size(); j++) {
			HSSFRow row4 = sheet.createRow(j+2);
			row4.createCell(0).setCellValue(list.get(j).getId());
			row4.createCell(1).setCellValue(list.get(j).getName());
			row4.createCell(2).setCellValue(list.get(j).getAddress());
			row4.createCell(3).setCellValue(list.get(j).getWchat());
			row4.createCell(4).setCellValue(list.get(j).getEmail());
			row4.createCell(5).setCellValue(list.get(j).getQQ());
			row4.createCell(6).setCellValue(list.get(j).getPhone());
			row4.createCell(7).setCellValue(list.get(j).getClassId());
			row4.createCell(8).setCellValue(list.get(j).getMessage());
		}
		
		//输出Excel文件
		try {
			FileOutputStream outputStream = new FileOutputStream("d:\\soft\\通讯录.xls");
			workbook.write(outputStream);

			JOptionPane.showMessageDialog(null, "导出成功");
			workbook.close();
			outputStream.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
