package Webzent.student_management_service.dto;

import Webzent.student_management_service.entity.StudentDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailResponse {

    private Integer studentId;
    private String studentName;
    private String fatherName;
    private String dateOfBirth;
    private String rollNumber;
    private String totalMark;
    private String status;

    public StudentDetailResponse buildStudentDetailResponse(StudentDetail studentDetail){
        this.studentId = Math.toIntExact(studentDetail.getStudentId());
        this.studentName = studentDetail.getStudentName();
        this.fatherName = studentDetail.getFatherName();
        this.dateOfBirth = String.valueOf(studentDetail.getDateOfBirth());
        this.rollNumber = studentDetail.getRollNumber().toString();
        this.totalMark = studentDetail.getTotalMark().toString();
        if(studentDetail.getStatus()) this.status = "Pass";
        else this.status = "Fail";
        return this;
    }
}
