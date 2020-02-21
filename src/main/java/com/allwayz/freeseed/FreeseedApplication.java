package com.allwayz.freeseed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FreeseedApplication extends SpringBootServletInitializer {
        @Override
        protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
            return application.sources(FreeseedApplication.class);
        }

        public static void main (String[]args){
            SpringApplication.run(FreeseedApplication.class, args);
        }
}
