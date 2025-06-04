package Webzent.student_management_service.util.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestResponseFactory {

    private static Map<String, ResponseCode> responseCodes;

    public static void initialize(List<ResponseCode> responseCodes) {
        RestResponseFactory.responseCodes = new HashMap<>();
        responseCodes.forEach(rc -> RestResponseFactory.responseCodes.put(rc.getId(), rc));
    }

    public static <T> ResponseEntity<RestResponse<T>> createResponse(T result, String messageId, HttpStatus httpStatus) {
        ResponseCode responseCode = responseCodes.get(messageId);
        Status status = httpStatus.value() / 100 == 2 ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(new RestResponse<>(httpStatus.value(), responseCode.getCode(), status, responseCode.getMessage(), result), httpStatus);
    }

}
