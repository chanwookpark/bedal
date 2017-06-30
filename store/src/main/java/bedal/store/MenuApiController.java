package bedal.store;

import bedal.model.store.MenuCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 음식에 대한 API
 *
 * @author chanwook
 */
@RestController
public class MenuApiController {

    @Autowired
    StoreDataService storeDataService;

    @GetMapping("/store/{storeId}/menu/category")
    public List<MenuCategory> menuCategoryList(@PathVariable String storeId) {

        List<MenuCategory> list = storeDataService.findMenuCategory(storeId);

        return list;
    }
}
