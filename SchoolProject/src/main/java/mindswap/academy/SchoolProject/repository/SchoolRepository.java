package mindswap.academy.SchoolProject.repository;


import mindswap.academy.SchoolProject.model.School;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
