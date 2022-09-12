package mindswap.academy.SchoolProject.repository;

import mindswap.academy.SchoolProject.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {

}
