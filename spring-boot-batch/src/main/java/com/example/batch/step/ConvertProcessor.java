package com.example.batch.step;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author zhangYanLong
 * @date 2019/11/7
 */
public class ConvertProcessor implements ItemProcessor<String,String> {

    @Override
    public String process(String data) throws Exception {
        return data+"ccc";
    }
}
