package bedal.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 메뉴. 메뉴는 반드시 메뉴카테고리에 속해야 한다
 *
 * @author chanwook
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

    private long menuNumber;

    private String menuName;

    private int salePrice;

    private MenuCategory menuCategory;

}
