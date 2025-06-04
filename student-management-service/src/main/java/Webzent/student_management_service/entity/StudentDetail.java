package Webzent.student_management_service.entity;

import Webzent.student_management_service.dto.StudentDetailRequest;
import Webzent.student_management_service.util.DateUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Student")
public class StudentDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long studentId;
    private String studentName;
    private String fatherName;
    private Date dateOfBirth;
    private Integer rollNumber;
    private Integer totalMark;
    private Boolean status;
    private Timestamp createdAt;
    private Timestamp modifiedDate;

    public StudentDetail buildForAdd(StudentDetailRequest studentDetailRequest){
        this.studentName = studentDetailRequest.getStudentName();
        this.fatherName = studentDetailRequest.getFatherName();
        this.dateOfBirth = DateUtil.convertStringToSqlDate(studentDetailRequest.getDateOfBirth());
        this.rollNumber = Integer.valueOf(studentDetailRequest.getRollNumber());
        this.totalMark = Integer.valueOf(studentDetailRequest.getTotalMark());
        this.status = studentDetailRequest.getStatus();
        this.createdAt = Timestamp.from(Instant.now());
        return this;
    }

    public StudentDetail buildForUpdate(StudentDetailRequest studentDetailRequest){
        this.studentName = studentDetailRequest.getStudentName();
        this.fatherName = studentDetailRequest.getFatherName();
        this.dateOfBirth = DateUtil.convertStringToSqlDate(studentDetailRequest.getDateOfBirth());
        this.rollNumber = Integer.valueOf(studentDetailRequest.getRollNumber());
        this.totalMark = Integer.valueOf(studentDetailRequest.getTotalMark());
        this.status = studentDetailRequest.getStatus();
        this.modifiedDate = Timestamp.from(Instant.now());
        return this;
    }
}
