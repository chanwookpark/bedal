package bedal.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 가게 정보
 *
 * @author chanwook
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {

    private String storeId;

    private String storeName;

    private String promotionTitle;

    private String storeAddress;
}
