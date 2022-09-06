package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.dto.OrderResponse;
import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.repository.TeacherRepository;
import mindswap.academy.SchoolProject.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private TeacherRepository teacherRepository;

    private VehiclesRepository vehiclesRepository;

    @GetMapping("/getListOfVehicles")
    public List<OrderResponse> getAllVehicles(){
        return teacherRepository.getAllVehicles();
    }
}
