package mindswap.academy.SchoolProject.command.teacher;

import mindswap.academy.SchoolProject.command.garage.GarageConverter;
import mindswap.academy.SchoolProject.command.vehicles.VehicleConverter;
import mindswap.academy.SchoolProject.model.Teacher;

import java.util.stream.Collectors;

public class TeacherConverter {
    public static TeacherDto convertToDto(Teacher teacher){
        return  TeacherDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .subject(teacher.getSubject())
                .build();

    }

    public static TeacherWitCarDto convertToTeacherWitCarDto(Teacher teacher){
        return TeacherWitCarDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .subject(teacher.getSubject())
                .vehicles(teacher.getVehicles().stream().map(VehicleConverter::convertToDto).collect(Collectors.toList()))
                .garages(teacher.getGaragesList().stream().map(GarageConverter::convertEntityToGarageDto).collect(Collectors.toList()))
                .build();
    }

    public static Teacher convertToEntity(TeacherDto teacherDto){
        return  Teacher.builder()
                .name(teacherDto.getName())
                .subject(teacherDto.getSubject())
                .build();
    }

    public static Teacher convertCreateTeacherDtoToEntity(CreateTeacherDto createTeacherDto){
        return Teacher.builder()
                .name(createTeacherDto.getName())
                .subject(createTeacherDto.getSubject())
                .password(createTeacherDto.getPassword())
                .build();
    }
}
