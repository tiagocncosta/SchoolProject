package mindswap.academy.SchoolProject.command.vehicles;

import mindswap.academy.SchoolProject.command.teacher.TeacherDto;
import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.model.Vehicles;

public class VehicleConverter {

    public static VehicleDto convertToDto(Vehicles vehicles){
        return VehicleDto.builder()
                .id(vehicles.getId())
                .fuel(vehicles.getFuel())
                .brand(vehicles.getBrand())
                .model(vehicles.getModel())
                .type(vehicles.getType())
                .build();
    }

    public static Vehicles convertToEntity(VehicleDto vehicleDto){
        return Vehicles.builder()
                .id(vehicleDto.getId())
                .fuel(vehicleDto.getFuel())
                .brand(vehicleDto.getBrand())
                .model(vehicleDto.getModel())
                .type(vehicleDto.getType())
                .build();
    }

    public static Vehicles convertCreateVehiclesDtoToEntity(CreateVehiclesDto createVehiclesDto){
        return Vehicles.builder()
                .fuel(createVehiclesDto.getFuel())
                .brand(createVehiclesDto.getBrand())
                .model(createVehiclesDto.getModel())
                .type(createVehiclesDto.getType())
                .build();
    }
}
