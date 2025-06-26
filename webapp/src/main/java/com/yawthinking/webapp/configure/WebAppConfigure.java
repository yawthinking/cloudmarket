package com.yawthinking.webapp.configure;

import com.yawthinking.core.support.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfigure {

    /**
     * 使用 Twitter snowflake 的演算法，產生不重複的整數序號，每台機器必須使用不同的 nodeId
     * 這邊預設從 環境變數 (environment variables) APP_NODE_ID 中設定，部署時必須注意
     *
     * @return
     */
    @Bean
    public Snowflake snowflake() {
        return new Snowflake();
    }


}
