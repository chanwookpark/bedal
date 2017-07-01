package bedal.front;

import bedal.front.api.EventApiService;
import bedal.front.api.StoreApiService;
import bedal.model.event.EventBanner;
import bedal.model.store.Store;
import bedal.model.store.StoreList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chanwook
 */
@Controller
public class StoreViewController {

    private final Logger logger = LoggerFactory.getLogger(StoreViewController.class);

    @Autowired
    StoreApiService storeApiService;

    @Autowired
    EventApiService eventApiService;

    @RequestMapping("/store/list.html")
    public String list(ModelMap model) {

        EventBanner banner = eventApiService.findEventBanner("MAIN");

        StoreList storeList = storeApiService.findList();

        model.put("storeList", storeList);
        if (banner != null) {
            model.put("banner", banner);
        } else {
            logger.warn("메인 배너가 null로 배너 노출하지 않음! 배너 확인 필요!");
        }

        return "store-list";
    }

    @RequestMapping("/store/view.html")
    public String view(@RequestParam(value = "storeId") String storeId,
                       ModelMap model) {
        logger.debug("가게 메인 페이지 (stoerId: {})", storeId);

        Store store = storeApiService.findOne(storeId);

        model.put("store", store);
        return "store-view";
    }
}
