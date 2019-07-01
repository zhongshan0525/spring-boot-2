package com.example.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 创建单元格写入图片
 * @Author: zhangyanlong
 * @Date: 2019/6/30 13:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiText4 {

    @Test
    public void contextLoads() throws Exception{
        //1.创建工作簿 HSSF提供读写Microsoft Excel XLS格式档案的功能。XSSF提供读写Microsoft Excel OOXML XLSX格式档案的功能。
        Workbook workbook = new XSSFWorkbook();
        //2.创建表单sheet
        Sheet sheet = workbook.createSheet();
        //3.读取图片流
        FileInputStream fis = new FileInputStream("E:\\poi\\02.jpg");
        //4.转化二进制数组
        byte[] bytes = IOUtils.toByteArray(fis);
        fis.read(bytes);
        //5. 向Excel添加一张图片,并返回该图片在Excel中的图片集合中的下标
        int index = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);//参数1:图片二进制数据,参数二:图片类型
        //绘图工具类
        CreationHelper helper = workbook.getCreationHelper();
        //创建一个绘图对象
        Drawing<?> patriarch = sheet.createDrawingPatriarch();
        //创建锚点,设置图片坐标
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(0);//从0开始
        anchor.setRow1(0);//从0开始
        //创建图片
        Picture picture = patriarch.createPicture(anchor, index);
        picture.resize();//自适应渲染图片

        //6.文件流
        FileOutputStream fos = new FileOutputStream("E:\\poi\\test3.xlsx");
        //7.写入文件
        workbook.write(fos);
        //8.关流
        fos.close();
    }
}
