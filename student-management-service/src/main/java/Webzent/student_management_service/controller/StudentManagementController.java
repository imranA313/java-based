package Webzent.student_management_service.controller;

import Webzent.student_management_service.dto.StudentDetailRequest;
import Webzent.student_management_service.dto.StudentDetailResponse;
import Webzent.student_management_service.service.StudentManagementService;
import Webzent.student_management_service.service.StudentManagementService1;
import Webzent.student_management_service.util.rest.RestResponse;
import Webzent.student_management_service.util.rest.RestResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class StudentManagementController {

    @Autowired
    @Qualifier("b")
    private StudentManagementService1 studentManagementService;

    @PostMapping("student")
    public ResponseEntity<RestResponse<Object>> addStudent(@RequestBody StudentDetailRequest studentDetailRequest){
        log.info("Received request to add student details");
        StudentDetailResponse studentDetailResponse = studentManagementService.addDetails(studentDetailRequest);
        return RestResponseFactory.createResponse(studentDetailResponse, "student.details.created", HttpStatus.CREATED);
    }
    @GetMapping("students")
    public ResponseEntity<RestResponse<Object>> getStudents(){
        log.info("Received request to student details listing");
        var responseResult = studentManagementService.getStudentList();
        return RestResponseFactory.createResponse(responseResult.getResult(), "student.details.listed", HttpStatus.OK);
    }
    @PutMapping("student/{id}")
    public ResponseEntity<RestResponse<Object>> update(@PathVariable("id") Long studentId,
                                                       @RequestBody StudentDetailRequest studentDetailRequest){
        log.info("Received request to update student detail");
        StudentDetailResponse studentDetailResponse = studentManagementService.updateStudentDetail(studentId, studentDetailRequest);
        return RestResponseFactory.createResponse(studentDetailResponse, "student.detail.updated", HttpStatus.OK);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable("id") Long studentId){
        log.info("Received request to delete student detail");
        studentManagementService.deleteStudentDetail(studentId);
        return RestResponseFactory.createResponse(null, "student.detail.deleted", HttpStatus.OK);
    }
}
