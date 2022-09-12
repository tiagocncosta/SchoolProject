package mindswap.academy.SchoolProject.command.garage;

import lombok.Builder;
import lombok.Data;
import mindswap.academy.SchoolProject.model.Teacher;

import java.util.List;

@Data
@Builder
public class GarageDto {
        private Integer id;
        private List<Teacher> teachersList;

}
