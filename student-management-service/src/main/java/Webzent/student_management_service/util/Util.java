package Webzent.student_management_service.util;
import Webzent.student_management_service.util.rest.ResponseCodeRepository;
import Webzent.student_management_service.util.rest.RestResponseFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Util {

    @PostConstruct
    public void initializeResponseCodes(){
        ResponseCodeRepository.initilaize();
        RestResponseFactory.initialize(ResponseCodeRepository.getResponseCodes());
    }

}
