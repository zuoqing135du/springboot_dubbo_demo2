//package com.zuoqing.web.config;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by gaomin on 2017/12/4.
// */
//
//@Configuration
//public class AmqpConfig {
//
//    public static final String EXCHANGE   = "spring-boot-exchange";
//    public static final String ROUTINGKEY = "spring-boot-routingKey";
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setAddresses("127.0.0.1:5672");
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setPublisherConfirms(true); //必须要设置
//        return connectionFactory;
//    }
//}