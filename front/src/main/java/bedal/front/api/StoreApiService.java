package bedal.front.api;

import bedal.model.store.Store;
import bedal.model.store.StoreList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static bedal.front.api.ApiHostConstants.API_HOST_W_STORE;

/**
 * Store API의 클라이언트 서비스
 *
 * @author chanwook
 */
@Service
public class StoreApiService {

    private final Logger logger = LoggerFactory.getLogger(StoreApiService.class);

    @Autowired
    RestTemplate template;

    @HystrixCommand(groupKey = "store", fallbackMethod = "fallbackForFindLst")
    public StoreList findList() {
        StoreList storeList =
                template.getForObject(API_HOST_W_STORE + "/store/list", StoreList.class);

        logger.debug("가게정보 조회 ({}개)", storeList.getList().size());
        return storeList;
    }

    @HystrixCommand(groupKey = "store", fallbackMethod = "fallbackForFindOne")
    public Store findOne(String storeId) {
        Store store = template.getForObject(API_HOST_W_STORE + "/store/single?storeId={storeId}", Store.class, storeId);

        logger.debug("가게정보 1개 조회 {}", storeId);
        return store;
    }

    public StoreList fallbackForFindLst() {

        logger.error("Executing fallback method... (fallbackForFindList)");

        return new StoreList();
    }

    public Store fallbackForFindOne(String storeId) {

        logger.error("Executing fallback method... (fallbackForFindOne, storeId={}", storeId);

        return new Store();
    }
}
