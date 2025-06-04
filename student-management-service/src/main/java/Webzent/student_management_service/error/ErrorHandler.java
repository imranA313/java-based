package Webzent.student_management_service.error;


import Webzent.student_management_service.error.exception.InvalidDateFormatException;
import Webzent.student_management_service.error.exception.InvalidRequestException;
import Webzent.student_management_service.error.exception.UnknownException;
import Webzent.student_management_service.util.rest.ResponseCode;
import Webzent.student_management_service.util.rest.ResponseCodeRepository;
import Webzent.student_management_service.util.rest.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidDateFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse handleInvalidDateFormatException(InvalidDateFormatException ex){
        ResponseCode responseCode = ResponseCodeRepository.findById(ex.getMessage());
        return new RestResponse<>(HttpStatus.BAD_REQUEST, responseCode, null);
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse handleInvalidRequestException(InvalidRequestException ex){
        ResponseCode responseCode = ResponseCodeRepository.findById(ex.getMessage());
        return new RestResponse<>(HttpStatus.BAD_REQUEST, responseCode, null);
    }

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse handleUnknownException(UnknownException ex){
        ResponseCode responseCode = ResponseCodeRepository.findById(ex.getMessage());
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, responseCode, null);
    }

}
