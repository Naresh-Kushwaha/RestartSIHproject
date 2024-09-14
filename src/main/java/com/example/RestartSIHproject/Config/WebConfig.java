<<<<<<< HEAD
package com.example.RestartSIHproject.Config;




import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**") // This allows CORS for all paths
                .allowedOriginPatterns("*") // This allows CORS for all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific HTTP methods
                .allowedHeaders("*") // This allows all headers
                .allowCredentials(true); // If you want to allow credentials
    }
}
=======
package com.example.RestartSIHproject.Config;




import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**") // This allows CORS for all paths
                .allowedOriginPatterns("*") // This allows CORS for all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific HTTP methods
                .allowedHeaders("*") // This allows all headers
                .allowCredentials(true); // If you want to allow credentials
    }
}
>>>>>>> c9d8a101bbabcfaba4e499baba2a1062480a6f13
