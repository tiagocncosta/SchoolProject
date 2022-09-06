package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.service.VehiclesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehiclesController {

    private final VehiclesService vehiclesService;

    public VehiclesController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @PostMapping
    public Vehicles createVehicle(@RequestBody Vehicles vehicles){
        return vehiclesService.createVehicle(vehicles);
    }

    @GetMapping
    public List<Vehicles> getAllVehicles (){
        return vehiclesService.getAllVehicles();
    }
}
