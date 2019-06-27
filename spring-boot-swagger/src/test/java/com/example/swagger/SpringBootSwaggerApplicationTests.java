package com.example.swagger;

import com.example.swagger.api.ServantControllerApi;
import com.example.swagger.model.Servant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSwaggerApplicationTests {

    @Autowired
    private ServantControllerApi servantControllerApi;

    @Test
    public void contextLoads() {
        List<Servant> all = servantControllerApi.findAll();
        System.out.println(all);
    }

}
