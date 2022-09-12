package mindswap.academy.SchoolProject.repository;


import mindswap.academy.SchoolProject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "SELECT t FROM Teacher t WHERE t.name IN :name")
    public List<Teacher> findUserByNameList(@Param("name") String name);

    }

