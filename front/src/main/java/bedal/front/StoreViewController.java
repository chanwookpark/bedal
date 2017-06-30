package bedal.front;

import bedal.model.store.Store;
import bedal.model.store.StoreList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
@Controller
public class StoreViewController {

    private final Logger logger = LoggerFactory.getLogger(StoreViewController.class);

    RestTemplate template = new RestTemplate();

    @RequestMapping("/store/list.html")
    public String list(ModelMap model) {
        StoreList storeList =
                template.getForObject("http://localhost:9021/store/store/list", StoreList.class);

        logger.debug("가게정보 조회 ({}개)", storeList.getList().size());

        model.put("storeList", storeList);
        return "store-list";
    }

    @RequestMapping("/store/view.html")
    public String view(@RequestParam(value = "storeId") String storeId,
                       ModelMap model) {

        logger.debug("가게 메인 페이지 (stoerId: {})", storeId);

        final Store store = template.getForObject("http://localhost:9021/store/store/single?storeId={storeId}", Store.class, storeId);

        model.put("store", store);
        return "store-view";
    }
}
