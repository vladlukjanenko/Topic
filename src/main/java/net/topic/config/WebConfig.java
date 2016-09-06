package net.topic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Main configuration class of web application.
 *
 * @author Vlad Lukjanenko
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "net.topic.controllers")
@Import(PersistenceConfig.class)
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Configure view resolver.
     *
     * @return {InternalResourceViewResolver} instance.
     * */
    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
