package com.aio.mes.manager.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// application.properties 파일에서 Windows 경로를 읽어옵니다.
    @Value("${upload.path.windows}")
    private String uploadPathWindows;

    // application.properties 파일에서 Linux 경로를 읽어옵니다.
    @Value("${upload.path.linux}")
    private String uploadPathLinux;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 현재 운영체제를 확인합니다.
        String os = System.getProperty("os.name").toLowerCase();
        
        // 운영체제가 Windows인 경우
        if (os.contains("win")) {
            // Windows 경로를 정적 리소스로 매핑합니다.
            registry.addResourceHandler("/facImages/**")
                    .addResourceLocations("file:/" + uploadPathWindows);
        } else {
            // 운영체제가 Linux인 경우
            // Linux 경로를 정적 리소스로 매핑합니다.
            registry.addResourceHandler("/facImages/**")
                    .addResourceLocations("file:" + uploadPathLinux);
        }

        // 기존의 정적 리소스 설정 (static 폴더 내 파일들을 매핑)
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
