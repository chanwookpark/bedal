package bedal.front.client;

import bedal.model.store.Store;
import bedal.model.store.StoreList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static bedal.front.client.ApiHostConstants.API_HOST_W_STORE;

/**
 * Store API의 클라이언트 서비스
 *
 * @author chanwook
 */
@Service
public class StoreApiClient {

    private final Logger logger = LoggerFactory.getLogger(StoreApiClient.class);

    RestTemplate template = new RestTemplate();

    public StoreList findList() {
        StoreList storeList =
                template.getForObject(API_HOST_W_STORE + "/store/list", StoreList.class);

        logger.debug("가게정보 조회 ({}개)", storeList.getList().size());
        return storeList;
    }

    public Store findOne(String storeId) {
        Store store = template.getForObject(API_HOST_W_STORE + "/store/single?storeId={storeId}", Store.class, storeId);

        logger.debug("가게정보 1개 조회 {}", storeId);
        return store;
    }
}
