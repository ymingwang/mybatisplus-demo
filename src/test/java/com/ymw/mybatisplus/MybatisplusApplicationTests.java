package com.ymw.mybatisplus;

import com.ymw.mybatisplus.exception.TaskException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Test
    public void contextLoads() throws TaskException {
        System.out.println(TaskException.Code.CONFIG_ERROR);
        throw new TaskException("The task misfire policy  cannot be used in cron schedule tasks", TaskException.Code.CONFIG_ERROR);
    }

}
