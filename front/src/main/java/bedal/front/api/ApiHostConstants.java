package bedal.front.api;

/**
 * API 호스트 주소 관리
 *
 * @author chanwook
 */
//TODO 우선 변수로 관리부터 시작
public interface ApiHostConstants {

    String API_HOST_W_GATEWAY = "http://localhost:9021";

    String API_HOST_W_STORE = API_HOST_W_GATEWAY + "/store";

    String API_HOST_W_EVENT = API_HOST_W_GATEWAY + "/event";


}
