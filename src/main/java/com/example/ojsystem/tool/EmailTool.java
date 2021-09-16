package com.example.ojsystem.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@CrossOrigin
@RequestMapping("/email")
public class EmailTool {
    @Autowired
    JavaMailSender javaMailSender;
    /**
     * 普通邮件发送
     */
    @RequestMapping(value = "/text", method = RequestMethod.POST)
    public Object sendSimpleMail() {
        int num=(int)(Math.random()*9000+1000);
        String randomNum = String.valueOf(num);
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("767324214@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("18005866682@163.com");
        // 设置邮件抄送人，可以有多个抄送人
        //message.setCc("12****32*qq.com");
        // 设置隐秘抄送人，可以有多个
        //message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("验证码为"+randomNum);
        // 发送邮件
        javaMailSender.send(message);
        return randomNum;
    }
}
