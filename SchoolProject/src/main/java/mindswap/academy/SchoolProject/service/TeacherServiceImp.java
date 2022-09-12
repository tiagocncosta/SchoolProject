package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.aop.LogExecutionTime;
import mindswap.academy.SchoolProject.command.teacher.CreateTeacherDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherConverter;
import mindswap.academy.SchoolProject.command.teacher.TeacherDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherWitCarDto;
import mindswap.academy.SchoolProject.command.vehicles.CreateVehiclesDto;
import mindswap.academy.SchoolProject.command.vehicles.VehicleDto;
import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImp implements TeacherService {

    private TeacherRepository teacherRepository;
    private VehiclesServiceImp vehiclesServiceImp;

    public TeacherServiceImp(TeacherRepository teacherRepository, VehiclesServiceImp vehiclesServiceImp) {
        this.teacherRepository = teacherRepository;
        this.vehiclesServiceImp = vehiclesServiceImp;
    }

    @Override
    public List<TeacherWitCarDto> getAllTeachersWithACarFromTheSameBrand(String vehicleBrand) {
        return (vehiclesServiceImp.getAllVehiclesfromThisBrand(vehicleBrand)
                .stream()
                .map(Vehicles::getTeacher)
                .collect(Collectors.toList()))
                .stream()
                .map(TeacherConverter::convertToTeacherWitCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto createTeacher(CreateTeacherDto teacher) {
        /*Teacher teacherEntity = TeacherConverter.convertCreateTeacherDtoToEntity(teacher);
        teacherRepository.save(teacherEntity);
        TeacherDto teacherDto = TeacherConverter.convertToDto(teacherEntity);
        return teacherDto;*/
        return TeacherConverter.convertToDto(teacherRepository.save(TeacherConverter.convertCreateTeacherDtoToEntity(teacher)));

    }

    @Override
    public TeacherDto getTeacherById(Integer idTeacher){
        Teacher teacher = getTeacherEntityById(idTeacher);

        return TeacherConverter.convertToDto(teacher);
    }

    @Override
    @LogExecutionTime
    public Teacher getTeacherEntityById(Integer idTeacher){
        return teacherRepository.findById(idTeacher).get();
    }

    @Override
    @LogExecutionTime
    public List<TeacherDto> getTeachersList() {

      return teacherRepository.findAll().stream()
                .toList()
                .stream().map(TeacherConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto createVehicle(CreateVehiclesDto vehicles) {
        return vehiclesServiceImp.createVehicle(vehicles);
    }

    @Override
    public TeacherDto addVehicleToTeacher(Integer idTeacher, Integer idCar) {
        Vehicles vehicles = vehiclesServiceImp.getVehicle(idCar);
        Teacher teacher = teacherRepository.findById(idTeacher).get();
        vehicles.setTeacher(teacher);
        teacher.getVehicles().add(vehicles);

        return TeacherConverter.convertToDto(teacherRepository.save(teacher));
    }

}
