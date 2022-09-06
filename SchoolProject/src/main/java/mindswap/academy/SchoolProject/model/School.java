package mindswap.academy.SchoolProject.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class School {

    @Id
    private Integer id;
    private String name;
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "school")
    private Set<Teacher> teachersList;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "school")
    private Set<ParkingSpot> parkingSpotsList;



}
