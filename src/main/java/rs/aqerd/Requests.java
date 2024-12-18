package rs.aqerd;

import feign.Headers;
import feign.RequestLine;
import rs.aqerd.models.AuthModel;

import java.util.Map;

public interface Requests {
    @RequestLine("POST /api/token")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json"
    })
    AuthModel getToken(Map<String, ?> form);
}
