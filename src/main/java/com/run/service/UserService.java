package com.run.service;

import com.run.event.SendEmailEvent;
import com.run.event.SendMessageEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author : hewei
 * @date : 2017/11/13 0:45
 */
public class UserService implements ApplicationEventPublisherAware {

    /**
     * 底层事件发布者
     */
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(//通过Set方法完成我们的实际发布者注入
                                             ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void doLogin(String emailAddress,String phoneNum) throws InterruptedException{
        //模拟用户注册的相关业务逻辑处理
        Thread.sleep(200);
        System.out.println("注册成功！");
        //下列向用户发送邮件
        //定义事件
        SendEmailEvent sendEmailEvent = new SendEmailEvent(this,emailAddress);
        SendMessageEvent sendMessageEvent = new SendMessageEvent(this, phoneNum);
        //发布事件
        applicationEventPublisher.publishEvent(sendEmailEvent);
        applicationEventPublisher.publishEvent(sendMessageEvent);
    }
    //...忽略其他用户管理业务方法
}
