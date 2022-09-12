package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.command.teacher.CreateTeacherDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherWitCarDto;
import mindswap.academy.SchoolProject.command.vehicles.CreateVehiclesDto;
import mindswap.academy.SchoolProject.command.vehicles.VehicleDto;
import mindswap.academy.SchoolProject.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherWitCarDto> getAllTeachersWithACarFromTheSameBrand(String vehicleBrand);

    TeacherDto createTeacher(CreateTeacherDto teacher);

    TeacherDto getTeacherById(Integer idTeacher);

    Teacher getTeacherEntityById(Integer idTeacher);

    List<TeacherDto> getTeachersList();

    VehicleDto createVehicle(CreateVehiclesDto vehicles);

    TeacherDto addVehicleToTeacher(Integer idTeacher, Integer idCar);
}
