package mindswap.academy.SchoolProject.command.vehicles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleDto {

    private Integer id;

    private String fuel;

    private String brand;

    private String model;

    private String type;

}
