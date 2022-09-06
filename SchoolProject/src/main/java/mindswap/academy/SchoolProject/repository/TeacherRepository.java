package mindswap.academy.SchoolProject.repository;


import mindswap.academy.SchoolProject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
