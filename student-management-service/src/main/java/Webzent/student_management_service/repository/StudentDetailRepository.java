package Webzent.student_management_service.repository;

import Webzent.student_management_service.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long> {

}
