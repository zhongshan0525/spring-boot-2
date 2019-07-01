package com.example.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;

/**
 * 创建单元格写入内容
 * @Author: zhangyanlong
 * @Date: 2019/6/30 13:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiText2 {

    @Test
    public void contextLoads() throws Exception{
        //1.创建工作簿 HSSF提供读写Microsoft Excel XLS格式档案的功能。XSSF提供读写Microsoft Excel OOXML XLSX格式档案的功能。
        Workbook workbook = new XSSFWorkbook();
        //2.创建表单sheet
        Sheet sheet = workbook.createSheet();
        //3.创建行对象 参数 索引(从0开始)
        Row row = sheet.createRow(2);
        //4.创建单元格对象 参数 索引(从0开始)
        Cell cell = row.createCell(2);
        //5.向单元格写入内容
        cell.setCellValue("阿尔托莉雅");
        //6.文件流
        FileOutputStream fos = new FileOutputStream("E:\\poi\\test1.xlsx");
        //7.写入文件
        workbook.write(fos);
        //8.关流
        fos.close();
    }
}
