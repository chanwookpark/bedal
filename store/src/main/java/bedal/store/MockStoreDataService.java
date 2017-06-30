package bedal.store;

import bedal.model.store.Menu;
import bedal.model.store.MenuCategory;
import bedal.model.store.Store;
import bedal.model.store.StoreList;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 임시 데이터를 제공하는 목업 데이터 클래스
 *
 * @author chanwook
 */
@Service
public class MockStoreDataService implements StoreDataService {

    static Map<String, Store> STORE_MAP = new HashMap<>();
    static List<MenuCategory> MENU_CATEGORY_LIST = new LinkedList<>();
    static List<Menu> MENU_LIST = new LinkedList<>();

    static {
        STORE_MAP.put("STR-001", new Store("STR-001", "수육나라", "윤기가좔좔흐르는 수육", "방이동 332번지"));
        STORE_MAP.put("STR-002", new Store("STR-002", "치킨뺑이", "끝내주는 튀김옷!!", "방이동 112번지"));

        MENU_CATEGORY_LIST.add(new MenuCategory(1001, "메인메뉴", STORE_MAP.get("STR-001")));
        MENU_CATEGORY_LIST.add(new MenuCategory(1002, "주류", STORE_MAP.get("STR-001")));
        MENU_CATEGORY_LIST.add(new MenuCategory(1003, "사이드", STORE_MAP.get("STR-001")));

        MENU_CATEGORY_LIST.add(new MenuCategory(1011, "치킨", STORE_MAP.get("STR-002")));
        MENU_CATEGORY_LIST.add(new MenuCategory(1012, "주류", STORE_MAP.get("STR-002")));

        MENU_LIST.add(new Menu(2001, "윤기보쌈", 20000, getMenuCategory(1001)));
        MENU_LIST.add(new Menu(2002, "마늘보쌈", 23000, getMenuCategory(1001)));
    }

    private static MenuCategory getMenuCategory(long menuCategoryNumber) {
        return MENU_CATEGORY_LIST.stream()
                .filter(c -> menuCategoryNumber == c.getMenuCategoryNumber())
                .findFirst().get();
    }

    @Override
    public List<MenuCategory> findMenuCategory(String storeId) {
        return MENU_CATEGORY_LIST.stream()
                .filter(c -> storeId.equals(c.getStore().getStoreId()))
                .collect(Collectors.toList());
    }

    @Override
    public StoreList findStoreList() {
        final List<Store> list = STORE_MAP.values().stream().collect(Collectors.toList());
        return new StoreList(list);
    }

    @Override
    public Store findOne(String storeId) {
        final Store store = STORE_MAP.get(storeId);
        if (store == null) {
            throw new RuntimeException("상점이 없어요 (id:" + storeId + ")");
        }
        return store;
    }
}
