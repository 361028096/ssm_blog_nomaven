package com.run.test;

import com.run.service.TestService;
import com.run.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    public static void main(String[] args) throws InterruptedException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        Long beginTime = System.currentTimeMillis();
        //完成注册请求
        userService.doLogin("wei.he@bkjk.com","12345678911");
        System.out.println("处理注册相关业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
        System.out.println("处理其他业务逻辑");
        //模拟处理其他业务请求耗时
        Thread.sleep(500);
        System.out.println("处理所有业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
        System.out.println("向客户端发送注册成功响应");
    }
}
