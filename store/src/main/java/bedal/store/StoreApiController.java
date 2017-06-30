package bedal.store;

import bedal.model.store.Store;
import bedal.model.store.StoreList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@RestController
public class StoreApiController {

    @Autowired
    StoreDataService storeDataService;

    @GetMapping("/store/list")
    public StoreList list() {
        return storeDataService.findStoreList();
    }

    @GetMapping("/store/single")
    public Store single(@RequestParam(value = "storeId") String storeId) {
        Store store = storeDataService.findOne(storeId);
        return store;
    }
}
