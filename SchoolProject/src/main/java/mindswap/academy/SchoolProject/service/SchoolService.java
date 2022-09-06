package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.model.School;
import mindswap.academy.SchoolProject.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getSchoolList() {
        return schoolRepository.findAll();
    }
}
