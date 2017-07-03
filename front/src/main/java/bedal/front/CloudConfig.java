package bedal.front;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
@Configuration
public class CloudConfig {
    @LoadBalanced
    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }
}
