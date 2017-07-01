package bedal.model.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chanwook
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventBanner implements Serializable {

    private String eventId;

    private String eventTitle;

    private String bannerImageUrl;

}
