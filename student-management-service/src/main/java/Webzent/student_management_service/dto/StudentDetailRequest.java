package Webzent.student_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailRequest {
    private String studentName;
    private String fatherName;
    private String dateOfBirth;
    private String rollNumber;
    private String totalMark;
    private Boolean status;

}
