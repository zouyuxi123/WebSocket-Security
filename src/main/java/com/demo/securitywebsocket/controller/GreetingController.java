package com.demo.securitywebsocket.controller;

import com.demo.securitywebsocket.bean.Chat;
import com.demo.securitywebsocket.bean.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author: 邹玉玺修改一下
 * @date: 2020/5/10-14:28
 */
@Controller
public class GreetingController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping ("/hello")
    @SendTo ("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }
    @MessageMapping("/chat")
   public void chat(Principal principal, Chat chat){
        String from=principal.getName();//获取当前用户的用户名
       System.out.println("当前用户是"+from+"消息发送给"+chat.getTo());
       chat.setFrom(from);//设置chat的from属性
       simpMessagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
         system.out.println("修改了")
   }
}
