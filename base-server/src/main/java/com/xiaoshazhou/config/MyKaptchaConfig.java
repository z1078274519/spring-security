package com.xiaoshazhou.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * TODO
 *
 * @author zhoujin
 * @date 2021/2/15 13:37
 */
@Configuration
@PropertySource("classpath:kaptcha.properties")
public class MyKaptchaConfig {

    @Value("${kaptcha.border}")
    private String border;
    @Value("${kaptcha.border.color}")
    private String borderColor;
    @Value("${kaptcha.image.width}")
    private String imageWidth;
    @Value("${kaptcha.image.height}")
    private String imageHeight;
    @Value("${kaptcha.textproducer.font.color}")
    private String fontColor;
    @Value("${kaptcha.textproducer.font.size}")
    private String fontSize;
    @Value("${kaptcha.textproducer.char.length}")
    private String charLength;
    @Value("${kaptcha.textproducer.font.names}")
    private String fontNames;
    @Value("${kaptcha.session.key}")
    private String sessionKey;

    @Bean(name = "captchaProducer")
    public DefaultKaptcha kaptcha() {
        DefaultKaptcha kaptcha = new DefaultKaptcha();

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", border);
        properties.setProperty("kaptcha.border.color", borderColor);
        properties.setProperty("kaptcha.image.width", imageWidth);
        properties.setProperty("kaptcha.image.height", imageHeight);
        properties.setProperty("kaptcha.textproducer.font.color", fontColor);
        properties.setProperty("kaptcha.textproducer.font.size", fontSize);
        properties.setProperty("kaptcha.textproducer.char.length", charLength);
        properties.setProperty("kaptcha.textproducer.font.names", fontSize);
        properties.setProperty("kaptcha.session.key", sessionKey);

        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;


    }
}
