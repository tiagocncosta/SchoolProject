package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.service.TeacherService;
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

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getTeachersList();
    }
}
