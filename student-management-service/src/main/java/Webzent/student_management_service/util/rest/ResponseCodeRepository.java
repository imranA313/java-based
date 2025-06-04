package Webzent.student_management_service.util.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseCodeRepository {
    private static Map<String, ResponseCode> responseCodesById;
    @Getter
    private static List<ResponseCode> responseCodes;
    private static final List<ResponseCode> defaultCodes;


    static {
        defaultCodes = new ArrayList<>();
        defaultCodes.add(new ResponseCode("student.details.created", 2001, "Student Detail created"));
        defaultCodes.add(new ResponseCode("student.details.listed", 2002, "Student Details listed"));
        defaultCodes.add(new ResponseCode("student.detail.updated", 2003, "Student Detail updated"));
        defaultCodes.add(new ResponseCode("student.detail.deleted", 2004, "Student Detail deleted"));
        defaultCodes.add(new ResponseCode("requestbody.missing", 2005, "Request body is missing"));
        defaultCodes.add(new ResponseCode("internalServerError", 2006, "Internal server error"));
    }

    public static void initilaize() {
        List<ResponseCode> responseCodes = new ArrayList<>(defaultCodes);
        responseCodesById = new HashMap<>();
        responseCodes.forEach(rc -> responseCodesById.put(rc.getId(), rc));
        ResponseCodeRepository.responseCodes = responseCodes;
    }

    public static ResponseCode findById(String id) {
        return responseCodesById.get(id);
    }
}
