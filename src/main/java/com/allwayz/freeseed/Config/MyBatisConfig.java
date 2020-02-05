package com.allwayz.freeseed.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.allwayz.freeseed.model.mapper")
public class MyBatisConfig {
}
