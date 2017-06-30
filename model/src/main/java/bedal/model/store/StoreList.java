package bedal.model.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 가게 목록 노출을 위한 리스트 클래스
 *
 * @author chanwook
 */
@Data
@NoArgsConstructor
public class StoreList implements Serializable {

    private List<Store> list = new ArrayList<>();

    public StoreList(List<Store> list) {
        this.list = list;
    }

    public StoreList add(Store store) {
        list.add(store);
        return this;
    }
}
