package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
@ComponentScan(basePackages = "backend.*")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
=======
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
>>>>>>> 507c81f clean backend
public class GoSpaceBackendApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication.run(GoSpaceBackendApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
