package bedal.event;

import bedal.model.event.EventBanner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@RestController
public class EventApiController {

    /**
     * 이벤트의 배너 조회 (1개만)
     *
     * @return
     */
    @GetMapping("/event/single/banner")
    public EventBanner getBannerForEvent(@RequestParam String eventId) {

        //FIXME 우선 여기서 간단히 리턴
        final EventBanner eventBanner = new EventBanner();
        eventBanner.setEventId(eventId);
        eventBanner.setEventTitle("보쌈10%할인");
        eventBanner.setBannerImageUrl("/images/banner/banner1.png");
        return eventBanner;
    }
}
