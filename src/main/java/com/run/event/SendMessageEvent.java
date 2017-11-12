package com.run.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @author: hewei
 * @date: 2017/11/13 0:30
 */
public class SendMessageEvent extends ApplicationEvent {

    private String phoneNum;

    public SendMessageEvent(Object  source,String phoneNum ) {
        super(source);
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
