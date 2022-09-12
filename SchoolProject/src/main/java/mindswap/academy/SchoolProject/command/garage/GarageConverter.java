package mindswap.academy.SchoolProject.command.garage;

import mindswap.academy.SchoolProject.model.Garage;

public class GarageConverter {

    public static GarageDto convertEntityToGarageDto(Garage garage){
        return GarageDto.builder()
                .id(garage.getId())
                .teachersList(garage.getTeachersList())
                .build();
    }
    public static Garage convertGarageDtoToEntity(GarageDto garageDto){
        return Garage.builder()
                .id(garageDto.getId())
                .teachersList(garageDto.getTeachersList())
                .build();
    }
    public static Garage convertCreateGarageDtoToEntity(CreateGarageDto createGarageDto){
        return Garage.builder()
                .build();
    }
}
