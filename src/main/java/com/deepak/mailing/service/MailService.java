package com.deepak.mailing.service;

import com.deepak.mailing.model.EmailDetails;

public interface MailService {
 String sendSimpleMail(EmailDetails details);
 String sendMailWithAttachment(EmailDetails details);
}
