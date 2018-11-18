package util;

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
//import org.omg.CORBA.PRIVATE_MEMBER;
public class ToExcel {
    public static void toExcel(String[][] table) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表
        HSSFSheet sheet = workbook.createSheet("sheet2");
        //创建第一行
        HSSFRow row = null;    //0行
        HSSFCell cell = null;
        //插入标题
        for (int i = 0; i < table.length; i++)//行
        {
            row = sheet.createRow(i);
            for (int j = 0; j < table[0].length; j++)//lie
            {
                cell = row.createCell(j);
                cell.setCellValue(table[i][j]);
            }
        }
        //创建一个文件,将Excel内容存盘
        String filePath = "workbook.xls";

        FileOutputStream output;
        try {
            output = new FileOutputStream(filePath);
            workbook.write(output);
            output.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
