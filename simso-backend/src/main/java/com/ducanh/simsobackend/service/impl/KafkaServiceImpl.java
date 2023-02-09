package com.ducanh.simsobackend.service.impl;

import com.ducanh.simsobackend.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;


@Service
public class KafkaServiceImpl implements KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("classpath:/templates/images/image-1.png")
    Resource resourceFile1;

    @Value("classpath:/templates/images/image-2.png")
    Resource resourceFile2;

    @Value("classpath:/templates/images/image-3.png")
    Resource resourceFile3;

    @Value("classpath:/templates/images/image-4.png")
    Resource resourceFile4;

    @Value("classpath:/templates/images/image-5.jpeg")
    Resource resourceFile5;

    @Value("classpath:/templates/images/image-6.png")
    Resource resourceFile6;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;


    @Override
    public void sendMailOrderQueue(String mess) {
        kafkaTemplate.send("mail-order", mess);
    }

    @KafkaListener(topics = "mail-order", groupId = "group-id")
    public void listen(String messageKafka) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        helper.setFrom("anhpdn3@gmail.com");
        helper.setTo("anhpdn2@gmail.com");
        helper.setSubject("ddm");
        String html = templateEngine.process("index.html", context);
        helper.setText(html, true);
        helper.addInline("image1.png", resourceFile1);
        helper.addInline("image2.png", resourceFile2);
        helper.addInline("image3.png", resourceFile3);
        helper.addInline("image4.png", resourceFile4);
        helper.addInline("image5.png", resourceFile5);
        helper.addInline("image6.png", resourceFile6);
        emailSender.send(message);
        System.out.println("Received Message in group - group-id: " + messageKafka);
    }
}
