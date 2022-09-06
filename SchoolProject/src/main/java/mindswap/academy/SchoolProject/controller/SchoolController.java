package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.model.School;
import mindswap.academy.SchoolProject.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/school")
@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public School createSchool(@RequestBody School school){
        School newSchool = schoolService.createSchool(school);
        return newSchool;
    }

    @GetMapping
    public List<School> getSchools(){
        return schoolService.getSchoolList();
    }


}
