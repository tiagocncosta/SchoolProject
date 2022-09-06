package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private VehiclesService vehiclesService;

    public TeacherService(TeacherRepository teacherRepository,VehiclesService vehiclesService) {
        this.teacherRepository = teacherRepository;
        this.vehiclesService = vehiclesService;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachersList() {
        return teacherRepository.findAll();
    }

    public Vehicles createVehicle(Vehicles vehicles) {
        return vehiclesService.createVehicle(vehicles);
    }

    public Teacher addVehicleToTeacher(Integer idTeacher, Integer idCar) {
        Vehicles vehicles = vehiclesService.getVehicle(idCar);
        Teacher teacher = teacherRepository.findById(idTeacher).get();
        teacher.getVehicles().add(vehicles);
        return teacher;
    }
}
