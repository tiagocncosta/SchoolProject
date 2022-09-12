package mindswap.academy.SchoolProject.command.vehicles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import mindswap.academy.SchoolProject.model.Teacher;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class CreateVehiclesDto {
    @NotBlank(message = "gas can't be blank")
    private String fuel;
    @NotBlank(message = "brand can't be blank")
    private String brand;
    @NotBlank(message = "model can't be blank")
    private String model;
    //@Pattern(regexp = "/(moto|car)/", message = "type can only be moto or car")
    private String type;

}

