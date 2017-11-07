package com.run.test;

import com.run.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
public class MainTest {

    @Autowired
    private TestService testService;

    @Test
    public void testSelectAll() {
        try {
            System.out.println(testService.selectAll());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertItem() {
        try {
            com.run.entity.Test test = new com.run.entity.Test();
            test.setId("24");
            test.setName("贺炜");
            testService.insertItem(test);
            System.out.println("insert 哈哈1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
