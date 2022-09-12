package mindswap.academy.SchoolProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fuel;

    private String brand;

    private String model;

    private String type;

   @ManyToOne
   @JsonIgnore
    private Teacher teacher;

}
