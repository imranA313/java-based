package Webzent.student_management_service.util.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {

    public RestResponse(Integer statusCode, Integer code, Status status, String message, T result) {
        this.statusCode = statusCode;
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public RestResponse(HttpStatus statusCode, ResponseCode responseCode, T result) {
        this.statusCode = statusCode.value();
        this.code = responseCode.getCode();
        this.status = statusCode.value() / 100 == 2 ? Status.SUCCESS : Status.FAIL;
        this.message = responseCode.getMessage();
        this.result = result;
    }

    private Integer statusCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;
    private Status status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer offset;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer size;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;
}
