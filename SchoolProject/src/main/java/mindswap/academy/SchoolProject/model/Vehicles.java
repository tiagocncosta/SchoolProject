package mindswap.academy.SchoolProject.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fuel;

    private String brand;

    private String model;

    private String type;

    @ManyToOne
    private Teacher teacher;

}
