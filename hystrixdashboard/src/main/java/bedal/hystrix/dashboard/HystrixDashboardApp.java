package bedal.hystrix.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chanwook
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp {

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApp.class).web(true).run(args);
    }
}
