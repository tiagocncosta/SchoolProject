package mindswap.academy.SchoolProject.repository;

import mindswap.academy.SchoolProject.dto.OrderResponse;
import mindswap.academy.SchoolProject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT mindswap.academy.SchoolProject.dto.OrderResponse(t.name, v.brand) FROM Teacher t JOIN t.vehicles v")
    public List<OrderResponse> getAllVehicles();
}
