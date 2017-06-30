package bedal.model.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 가게 별로 메뉴를 관리하는 단위.
 * 카테고리지는 1뎁스만 존재한다.
 *
 * @author chanwook
 */
@Data
@NoArgsConstructor
public class MenuCategory {

    private long menuCategoryNumber;

    private String menuCategoryName;

    private Store store;

    private List<Menu> menuList = new ArrayList<>();

    public MenuCategory(long menuCategoryNumber, String menuCategoryName, Store store) {
        this.menuCategoryNumber = menuCategoryNumber;
        this.menuCategoryName = menuCategoryName;
        this.store = store;
    }
}
