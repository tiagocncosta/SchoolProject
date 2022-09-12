package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.command.garage.CreateGarageDto;
import mindswap.academy.SchoolProject.command.garage.GarageDto;
import mindswap.academy.SchoolProject.command.teacher.TeacherDto;
import mindswap.academy.SchoolProject.model.Garage;
import mindswap.academy.SchoolProject.service.GarageService;
import mindswap.academy.SchoolProject.service.GarageServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/garage")
@RestController
public class GarageController {
    private GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public ResponseEntity<?> createGarage(@Valid @RequestBody CreateGarageDto garage, BindingResult bindingResult) {
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
        return new ResponseEntity<>(garageService.createGarage(garage), HttpStatus.CREATED);
    }

    @GetMapping("/idGarage")
    public ResponseEntity<GarageDto> getGarageDtoById(@PathVariable Integer idGarage){
        return new ResponseEntity<>(garageService.getGarageDtoById(idGarage), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GarageDto>> getAllGarageDto(){
        return new ResponseEntity<>(garageService.getAllGarageDto(), HttpStatus.OK);
    }

    @PutMapping("/idGarage={idGarage}/idTeacher={idTeacher}")
    public ResponseEntity<GarageDto> addNewTeacher(@PathVariable Integer idGarage,@PathVariable Integer idTeacher){
        if (idGarage == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (idTeacher == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(garageService.addNewTeacher(idGarage, idTeacher), HttpStatus.OK);

    }


}
