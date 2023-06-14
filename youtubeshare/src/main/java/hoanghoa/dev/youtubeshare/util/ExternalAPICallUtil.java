package hoanghoa.dev.youtubeshare.util;

import com.fasterxml.jackson.databind.JsonNode;
import hoanghoa.dev.youtubeshare.constant.APIKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public class ExternalAPICallUtil {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    public static JsonNode call(String videoId) {
        String url = APIKey.GOOGLE_API_HOST + "&id=" + videoId +
                "&key=" + APIKey.GOOGLE_API_KEY;
        return REST_TEMPLATE.getForObject(url, JsonNode.class);
    }
}
