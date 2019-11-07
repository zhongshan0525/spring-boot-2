package com.example.batch.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


/**
 * @author zhangYanLong
 * @date 2019/11/7
 */
@Slf4j
public class StringReader implements ItemReader<String> {

    private String[] messages = {"aaa1","aaa2","aaa3","aaa4"};
    private int count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(count < messages.length){
            String message = messages[count++];
            log.debug("read data:"+message);
            return message;
        }else{
            log.debug("read data end.");
            count = 0;
        }
        return null;
    }
}
