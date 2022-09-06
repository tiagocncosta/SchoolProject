package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.service.TeacherService;
import mindswap.academy.SchoolProject.service.VehiclesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teacher")
@RestController
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

   @PostMapping("/addVehicle")
    public Vehicles createVehicles(@RequestBody Vehicles vehicles){
        return teacherService.createVehicle(vehicles);
    }

    @PostMapping("/{idTeacher}/{idVehicle}")
    public Teacher addVehicleToTeacher(@PathVariable Integer idTeacher, @PathVariable Integer idVehicle){
        return teacherService.addVehicleToTeacher(idTeacher, idVehicle);
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getTeachersList();
    }
}
