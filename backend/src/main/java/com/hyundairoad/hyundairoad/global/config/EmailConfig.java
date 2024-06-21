//package com.hyundairoad.hyundairoad.global.config;
//
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Slf4j
//@Getter
//@Configuration
//@PropertySource("classpath:application.yml")
//public class EmailConfig {
//    @Value("${mail.google.host}")
//    private String host;
//
//    @Value("${mail.google.username}")
//    private String username;
//
//    @Value("${mail.google.password}")
//    private String password;
//
//    @Value("${mail.google.port}")
//    private int port;
//
//    @Bean
//    public JavaMailSender mailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(host);
//        mailSender.setPort(port);
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//
//        Properties javaMailProperties = new Properties();
//        javaMailProperties.put("mail.transport.protocol", "smtp");//프로토콜로 smtp 사용
//        javaMailProperties.put("mail.smtp.auth", "true");//smtp 서버에 인증이 필요
//        javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//SSL 소켓 팩토리 클래스 사용
//        javaMailProperties.put("mail.smtp.starttls.enable", "true");//STARTTLS(TLS를 시작하는 명령)를 사용하여 암호화된 통신을 활성화
//        javaMailProperties.put("mail.debug", "true");//디버깅 정보 출력
//        javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");//smtp 서버의 ssl 인증서를 신뢰
//        javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");//사용할 ssl 프로토콜 버젼
//
//        mailSender.setJavaMailProperties(javaMailProperties);
//
//        return mailSender;
//    }
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties(Environment env) {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        yaml.setResources(new ClassPathResource("application.yml"));
//        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
//        return propertySourcesPlaceholderConfigurer;
//    }
//
//}
