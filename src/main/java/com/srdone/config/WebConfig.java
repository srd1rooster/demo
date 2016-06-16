//package com.srdone.config;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//
///**
// * Created by lszakacs on 0016, June 16, 2016.
// */
//@Configuration
//@EnableWebMvc
//public class WebConfig extends WebMvcConfigurerAdapter {
//    //start Thymeleaf specific configuration
////    @Bean(name = "templateResolver")
////    public ServletContextTemplateResolver getTemplateResolver() {
////        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
////        templateResolver.setPrefix("classpath:resources/templates/");
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode("HTML5");
////        return templateResolver;
////    }
////
////    @Bean(name = "templateEngine")
////    public SpringTemplateEngine getTemplateEngine() {
////        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(getTemplateResolver());
////        return templateEngine;
////    }
////
////    @Bean(name = "viewResolver")
////    public ThymeleafViewResolver getViewResolver() {
////        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
////        viewResolver.setTemplateEngine(getTemplateEngine());
////        return viewResolver;
////    }
////
////    //end Thymeleaf specific configuration
////    @Bean(name = "messageSource")
////    public MessageSource getMessageSource() {
////        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
////        messageSource.setBasename("/WEB-INF/i18/blogmsg");
////        messageSource.setDefaultEncoding("UTF-8");
////        return messageSource;
////    }
//}