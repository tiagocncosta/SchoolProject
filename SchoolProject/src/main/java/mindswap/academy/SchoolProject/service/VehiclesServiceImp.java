package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.command.vehicles.CreateVehiclesDto;
import mindswap.academy.SchoolProject.command.vehicles.VehicleConverter;
import mindswap.academy.SchoolProject.command.vehicles.VehicleDto;
import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiclesServiceImp implements VehiclesService {
    @Autowired
    private final VehiclesRepository vehiclesRepository;

    public VehiclesServiceImp(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }


    @Override
    public VehicleDto createVehicle(CreateVehiclesDto vehicles) {
        return VehicleConverter
                .convertToDto(vehiclesRepository.save(VehicleConverter.convertCreateVehiclesDtoToEntity(vehicles)));

    }

    @Override
    public Vehicles getVehicle(Integer idCar) {
        if(vehiclesRepository.findById(idCar).isPresent()){
              return vehiclesRepository.findById(idCar).get();
        }
        return null;
    }

    @Override
    public List<Vehicles> getAllVehiclesfromThisBrand(String vehicleBrand) {
        return vehiclesRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(vehicleBrand))
                .collect(Collectors.toList());
    }
}
