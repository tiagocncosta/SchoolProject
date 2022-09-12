package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.command.vehicles.CreateVehiclesDto;
import mindswap.academy.SchoolProject.command.vehicles.VehicleDto;
import mindswap.academy.SchoolProject.model.Vehicles;

import java.util.List;

public interface VehiclesService {
    VehicleDto createVehicle(CreateVehiclesDto vehicles);

    Vehicles getVehicle(Integer idCar);

    List<Vehicles> getAllVehiclesfromThisBrand(String vehicleBrand);
}
