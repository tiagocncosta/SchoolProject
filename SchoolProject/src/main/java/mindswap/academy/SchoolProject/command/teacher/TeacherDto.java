package mindswap.academy.SchoolProject.command.teacher;

import lombok.Builder;
import lombok.Data;
import mindswap.academy.SchoolProject.command.vehicles.VehicleDto;
import mindswap.academy.SchoolProject.model.Garage;
import mindswap.academy.SchoolProject.model.Vehicles;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class TeacherDto {
    private Integer id;
    private String name;
    private String subject;

}
