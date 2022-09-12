package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.command.garage.CreateGarageDto;
import mindswap.academy.SchoolProject.command.garage.GarageDto;
import mindswap.academy.SchoolProject.model.Garage;

import java.util.List;

public interface GarageService {
    public GarageDto createGarage(CreateGarageDto garage);

    public GarageDto addNewTeacher(Integer idGarage, Integer idTeacher);

    GarageDto getGarageDtoById(Integer idGarage);

    List<GarageDto> getAllGarageDto();
}
