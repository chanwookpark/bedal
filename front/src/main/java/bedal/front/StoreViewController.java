package bedal.front;

import bedal.front.client.StoreApiClient;
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
    StoreApiClient storeApiClient;

    @RequestMapping("/store/list.html")
    public String list(ModelMap model) {

        StoreList storeList = storeApiClient.findList();

        model.put("storeList", storeList);
        return "store-list";
    }

    @RequestMapping("/store/view.html")
    public String view(@RequestParam(value = "storeId") String storeId,
                       ModelMap model) {
        logger.debug("가게 메인 페이지 (stoerId: {})", storeId);

        Store store = storeApiClient.findOne(storeId);

        model.put("store", store);
        return "store-view";
    }
}
