package mindswap.academy.SchoolProject.service;


import mindswap.academy.SchoolProject.command.garage.CreateGarageDto;
import mindswap.academy.SchoolProject.command.garage.GarageConverter;
import mindswap.academy.SchoolProject.command.garage.GarageDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherConverter;
import mindswap.academy.SchoolProject.model.Garage;
import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.repository.GarageRepository;
import mindswap.academy.SchoolProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GarageServiceImp implements GarageService {
    private GarageRepository garageRepository;
    private TeacherServiceImp teacherServiceImp;

    public GarageServiceImp(GarageRepository garageRepository, TeacherServiceImp teacherServiceImp) {
        this.garageRepository = garageRepository;
        this.teacherServiceImp = teacherServiceImp;
    }

    @Override
    public GarageDto createGarage(CreateGarageDto garage) {

        return GarageConverter.convertEntityToGarageDto(garageRepository.save(GarageConverter.convertCreateGarageDtoToEntity(garage)));
    }

    @Override
    public GarageDto addNewTeacher(Integer idGarage, Integer idTeacher) {
        Garage garage = garageRepository.findById(idGarage).get();
        Teacher teacher = teacherServiceImp.getTeacherEntityById(idTeacher);
        teacher.getGaragesList().add(garage);
        garage.getTeachersList().add(teacher);

        return GarageConverter.convertEntityToGarageDto(garageRepository.save(garage));
    }

    @Override
    public GarageDto getGarageDtoById(Integer idGarage) {
        return GarageConverter.convertEntityToGarageDto(garageRepository.findById(idGarage).get());
    }

    @Override
    public List<GarageDto> getAllGarageDto() {
       return garageRepository.findAll().stream().map(GarageConverter::convertEntityToGarageDto).collect(Collectors.toList());
    }


}
