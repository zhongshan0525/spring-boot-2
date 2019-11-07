package com.example.batch.test;

import com.example.batch.SpringBootBatchApplication;
import com.example.batch.config.ConsoleBatchConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangYanLong
 * @date 2019/11/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootBatchApplication.class, ConsoleBatchConfig.class})
@Slf4j
public class ConsoleJobTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job consoleJob;

    @Test
    public void testConsoleJob2() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        //构建参数
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        //执行任务
        JobExecution run = jobLauncher.run(consoleJob, jobParameters);
        ExitStatus exitStatus = run.getExitStatus();
        log.debug(exitStatus.toString());
    }

}
