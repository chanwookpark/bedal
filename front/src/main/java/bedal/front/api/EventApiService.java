package bedal.front.api;

import bedal.model.event.EventBanner;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static bedal.front.api.ApiHostConstants.API_HOST_W_EVENT;

/**
 * @author chanwook
 */
@Service
public class EventApiService {

    private final Logger logger = LoggerFactory.getLogger(EventApiService.class);

    RestTemplate template = new RestTemplate();

    @HystrixCommand(groupKey = "event", fallbackMethod = "fallbackForFindEventBanner")
    public EventBanner findEventBanner(String eventId) {
        final String url = API_HOST_W_EVENT + "/event/single/banner?eventId={eventId}";
        final EventBanner eventBanner = template.getForObject(url, EventBanner.class, eventId);

        logger.debug("EventBanner for Main : {}", eventBanner);

        return eventBanner;
    }

    public EventBanner fallbackForFindEventBanner(String eventId) {
        logger.error("Executing fallback method for findEventBanner!");

        return null;
    }
}
