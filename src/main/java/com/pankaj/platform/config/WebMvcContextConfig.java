package com.pankaj.platform.config;

import com.pankaj.platform.transformer.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pankajpardasani on 14/08/2016.
 */

@Configuration
public class WebMvcContextConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/index.html").setViewName("home");
        //registry.addViewController("/login.html").setViewName("login");
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(dateFormatter());
    }


    @Bean
    public DateConverter dateFormatter() {
        return new DateConverter();
    }
}
