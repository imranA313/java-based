package Webzent.student_management_service.service;

import Webzent.student_management_service.dto.ResponseResult;
import Webzent.student_management_service.dto.StudentDetailRequest;
import Webzent.student_management_service.dto.StudentDetailResponse;
import Webzent.student_management_service.entity.StudentDetail;
import Webzent.student_management_service.repository.StudentDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("b")
@Slf4j
public class StudentManagementService1 {

    @Autowired
    private StudentDetailRepository studentDetailRepository;

    public StudentDetailResponse addDetails(StudentDetailRequest request) {

        StudentDetail studentDetail = new StudentDetail().buildForAdd(request);
        StudentDetail outStudentDetail = studentDetailRepository.save(studentDetail);

        return new StudentDetailResponse().buildStudentDetailResponse(outStudentDetail);
    }

    public ResponseResult getStudentList(){
        List<StudentDetail> studentDetailResponseList = studentDetailRepository.findAll();
        return new ResponseResult<>(studentDetailResponseList.stream()
                .map(s -> new StudentDetailResponse().buildStudentDetailResponse(s))
                .collect(Collectors.toList()));
    }

    public StudentDetailResponse updateStudentDetail(Long studentId, StudentDetailRequest studentDetailRequest){
        StudentDetail studentDetail;
       Optional<StudentDetail> optional = studentDetailRepository.findById(studentId);
       if(optional.isPresent()) {
           studentDetail = optional.get();
           studentDetail.buildForUpdate(studentDetailRequest);
           return new StudentDetailResponse().buildStudentDetailResponse(studentDetailRepository.save(studentDetail));
       }
       return new StudentDetailResponse();
    }

    public void deleteStudentDetail(Long studentId){
        studentDetailRepository.deleteById(studentId);
    }
}
