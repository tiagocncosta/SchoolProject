package mindswap.academy.SchoolProject.command.parkingSpot;

import lombok.Builder;
import lombok.Data;
import mindswap.academy.SchoolProject.model.Teacher;

@Data
@Builder
public class ParkingSpotDto {
    private Integer id;
    private Teacher teacher;
}
