package com.yawthinking.core.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.yawthinking.core"})
public class MapperConfigure {
}
