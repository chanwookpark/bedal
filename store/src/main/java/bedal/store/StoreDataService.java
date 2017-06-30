package bedal.store;

import bedal.model.store.MenuCategory;
import bedal.model.store.Store;
import bedal.model.store.StoreList;

import java.util.List;

/**
 * @author chanwook
 */
public interface StoreDataService {

    /**
     * 매장의 메뉴 카테고리와 메뉴 정보 조회
     *
     * @param storeId
     * @return
     */
    List<MenuCategory> findMenuCategory(String storeId);

    /**
     * 전체 상점 목록 조회
     *
     * @return
     */
    StoreList findStoreList();

    /**
     * 상점 1개 조회
     *
     * @param storeId
     * @return
     */
    Store findOne(String storeId);
}
