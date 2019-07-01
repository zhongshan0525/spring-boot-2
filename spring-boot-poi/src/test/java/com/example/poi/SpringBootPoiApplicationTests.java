package com.example.poi;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;

/**
 * 使用poi创建excel
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootPoiApplicationTests {

    @Test
    public void contextLoads() throws Exception{
        //1.创建工作簿 HSSF提供读写Microsoft Excel XLS格式档案的功能。XSSF提供读写Microsoft Excel OOXML XLSX格式档案的功能。
        Workbook workbook = new XSSFWorkbook();
        //2.创建表单sheet
        Sheet sheet = workbook.createSheet();
        //3.文件流
        FileOutputStream fos = new FileOutputStream("E:\\poi\\test.xlsx");
        //4.写入文件
        workbook.write(fos);
        //5.关流
        fos.close();
    }

}
