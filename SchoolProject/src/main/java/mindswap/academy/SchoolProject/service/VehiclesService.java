package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.repository.VehiclesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService {

    private final VehiclesRepository vehiclesRepository;

    public VehiclesService(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }


    public Vehicles createVehicle(Vehicles vehicles) {
        return vehiclesRepository.save(vehicles);
    }

    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();
    }

    public Vehicles getVehicle(Integer idCar) {
        if(vehiclesRepository.findById(idCar).isPresent()){
              return vehiclesRepository.findById(idCar).get();
        }
        return null;
    }
}
