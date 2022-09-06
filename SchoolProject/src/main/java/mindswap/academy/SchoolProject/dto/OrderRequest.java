package mindswap.academy.SchoolProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mindswap.academy.SchoolProject.model.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
   private Teacher teacher;

}
