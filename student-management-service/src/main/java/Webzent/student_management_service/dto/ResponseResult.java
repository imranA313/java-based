package Webzent.student_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Data
public class ResponseResult <T> {
   private List<T> result;
}
