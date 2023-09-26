package com.orkva.project.xmall.product.config;

import com.fasterxml.jackson.databind.Module;
import com.orkva.xmall.common.config.CustomInstantModule;
import com.orkva.xmall.common.config.SnowflakeIdConfig;
import com.orkva.xmall.common.config.SwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * SwaggerConfig
 *
 * @author Shepherd Xie
 * @version 2023/8/9
 */
@Configuration
@Import({
        SwaggerConfig.class,
        SnowflakeIdConfig.class
})
public class CommonConfig {

    @Bean
    public Module customInstantModule() {
        return new CustomInstantModule();
    }

}
