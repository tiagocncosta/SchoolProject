package mindswap.academy.SchoolProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mindswap.academy.SchoolProject.command.garage.GarageDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String subject;
    private String password;


    @OneToOne
    @JsonIgnore
    private ParkingSpot parkingSpot;

    @OneToMany(mappedBy = "teacher")
    private List<Vehicles> vehicles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Garage> garagesList;



}
