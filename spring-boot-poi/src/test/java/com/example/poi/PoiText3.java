package com.example.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;

/**
 * 设置单元格样式
 * @Author: zhangyanlong
 * @Date: 2019/6/30 13:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiText3 {

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


        //创建单元格样式对象
        CellStyle cellStyle = workbook.createCellStyle();
        //设置边框
        cellStyle.setBorderBottom(BorderStyle.DASH_DOT);//下边框
        cellStyle.setBorderTop(BorderStyle.HAIR);//上边框
        //设置字体
        Font font = workbook.createFont();//创建字体对象
        font.setFontName("华文行楷");//设置字体
        font.setFontHeightInPoints((short)28);//设置字号
        cellStyle.setFont(font);
        //设置宽高
        sheet.setColumnWidth(2, 31 * 256);//设置第一列的宽度是31个字符宽度
        row.setHeightInPoints(50);//设置行的高度是50个点
        //设置居中显示
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        //设置单元格样式
        cell.setCellStyle(cellStyle);


        //6.文件流
        FileOutputStream fos = new FileOutputStream("E:\\poi\\test2.xlsx");
        //7.写入文件
        workbook.write(fos);
        //8.关流
        fos.close();
    }
}
