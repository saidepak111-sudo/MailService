package com.deepak.mailing.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.deepak.mailing.model.EmailDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class MailServiceImpl implements MailService{
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;    
    public MailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(details.getRecipient());
        mimeMessageHelper.setText(details.getMsgBody());
        mimeMessageHelper.setSubject(details.getSubject());
        FileSystemResource file =new FileSystemResource(new File(details.getAttachment()));
        mimeMessageHelper.addAttachment(file.getFilename(), file);
        javaMailSender.send(mimeMessage);
        return "Mail sent with attachment successfully...";
    } catch (MessagingException e) {
        e.printStackTrace();
        return "Error while sending mail with attachment!!!";
    }
    }

    @Override
    public String sendSimpleMail(EmailDetails details) {
     
             try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            e.getStackTrace();
            return "Error while sending mail!!!";
        }
    }

}
