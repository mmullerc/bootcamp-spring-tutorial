package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//Annotations

@SpringBootApplication //Provides SpringBoot configuration
@ComponentScan(basePackages = "controllers,contracts,services,pojos") //This annotation scans the given packages for BEANS adds them to the context application path
@EnableJpaRepositories("repositories") //Enables Java Persistence API repositories
@EntityScan(basePackages = "ejb")// SCANS for Enterprise Java beans and adds them to the context application path

/**
 * SpringBoot Application
 *
 */
public class Application {

	/**
	 * Main Application method.
	 * 
	 * Here Spring instantiates the Application
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
    
    /**
     * CORS configuration method
     * 
     * Here we specify what routes are allowed to have cross origin requests
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/todos").allowedOrigins("*");
            }
            
        };
    }

}
