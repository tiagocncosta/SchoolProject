package mindswap.academy.SchoolProject.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String subject;

    @ManyToOne
    private School school;

    @OneToOne(mappedBy = "teacher")
    private ParkingSpot parkingSpot;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "teacher"
    )
    private Set<Vehicles> vehicles;



}
