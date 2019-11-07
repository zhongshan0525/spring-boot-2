package com.example.batch.step;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author zhangYanLong
 * @date 2019/11/7
 */
public class ConsoleWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
