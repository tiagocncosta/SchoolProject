package mindswap.academy.SchoolProject.model;

import lombok.*;
import mindswap.academy.SchoolProject.command.teacher.TeacherDto;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   @ManyToMany(mappedBy = "garagesList",
    fetch = FetchType.LAZY)
    private List<Teacher> teachersList;

}
