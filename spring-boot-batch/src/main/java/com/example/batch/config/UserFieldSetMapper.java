package com.example.batch.config;

import com.example.batch.model.SysLog;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author zhangYanLong
 * @date 2019/11/20
 */
public class UserFieldSetMapper implements FieldSetMapper<SysLog> {

    @Override
    public SysLog mapFieldSet(FieldSet fieldSet) throws BindException {
        String patternYmd = "yyyy-MM-dd";
        String patternYmdHms = "yyyy-MM-dd HH:mm:ss";
        SysLog user = new SysLog();
        user.setId(fieldSet.readInt("id"));
        user.setUsername(fieldSet.readString("username"));
        user.setOperation(fieldSet.readString("operation"));
        user.setTime(fieldSet.readInt("time"));
        user.setMethod(fieldSet.readString("method"));
        user.setParams(fieldSet.readString("params"));
        //此字段有可能为null
//        String dataOfBirthStr = fieldSet.readString("date_of_birth");
//        if(SyncConstants.STR_CSV_NULL.equals(dataOfBirthStr)){
//            user.setDateOfBirth(null);
//        }else{
//            DateTime dateTime = DateUtil.parse(dataOfBirthStr, patternYmd);
//            user.setDateOfBirth(dateTime.toJdkDate());
//        }
        user.setIp(fieldSet.readString("ip"));
        user.setCreateTime(fieldSet.readDate("create_time",patternYmdHms));
        return user;

    }
}
