package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.command.teacher.CreateTeacherDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherWitCarDto;
import mindswap.academy.SchoolProject.command.vehicles.CreateVehiclesDto;
import mindswap.academy.SchoolProject.service.TeacherService;
import mindswap.academy.SchoolProject.service.TeacherServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/teacher")
@RestController
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@Valid @RequestBody CreateTeacherDto teacher, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //Map<String, String> errors = new HashMap<>();
            List<String> errorCodes = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();


            /*bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });*/
            return new ResponseEntity<>(errorCodes, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacherService.createTeacher(teacher), HttpStatus.CREATED);
    }

    @PostMapping("/addVehicle")
    public ResponseEntity<?> createVehicles(@Valid @RequestBody CreateVehiclesDto vehicles, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errorCodes = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errorCodes, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacherService.createVehicle(vehicles), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        return new ResponseEntity<>(teacherService.getTeachersList(), HttpStatus.OK);
    }

    @GetMapping("/idTeacher={idTeacher}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Integer idTeacher){
        if(idTeacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TeacherDto teacher = teacherService.getTeacherById(idTeacher);
        if(teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/brand={vehicleBrand}")
    public ResponseEntity<List<TeacherWitCarDto>> getAllTeachersWithACarFromTheSameBrand(@PathVariable String vehicleBrand){
        return new ResponseEntity<>(teacherService.getAllTeachersWithACarFromTheSameBrand(vehicleBrand), HttpStatus.OK);
    }

    @PutMapping("/idTeacher={idTeacher}/idVehicle={idVehicle}")
    public ResponseEntity<TeacherDto> addVehicleToTeacher(@PathVariable Integer idTeacher, @PathVariable Integer idVehicle){
        if(idTeacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(idVehicle == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(teacherService.addVehicleToTeacher(idTeacher, idVehicle), HttpStatus.OK);
    }








}
