package com.deepak.mailing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.deepak.mailing.model.EmailDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MailController {
private com.deepak.mailing.service.MailService mailService;
MailController(com.deepak.mailing.service.MailService mailService){
    this.mailService=mailService;
}
@PostMapping("/sendMail")
public String sendMail(@RequestBody EmailDetails  mail   ) {
    return mailService.sendSimpleMail(mail);
}
@PostMapping("/sendMailWithAttachment")
public String sendMailWithAttachment(@RequestBody EmailDetails  mail   ) {
    return mailService.sendMailWithAttachment(mail);
}
}
