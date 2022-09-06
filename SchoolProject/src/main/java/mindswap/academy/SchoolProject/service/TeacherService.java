package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachersList() {
        return teacherRepository.findAll();
    }
}
