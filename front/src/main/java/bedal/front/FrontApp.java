package bedal.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author chanwook
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
public class FrontApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FrontApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FrontApp.class, args);
    }

}
