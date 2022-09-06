package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.model.ParkingSpot;
import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.service.ParkingSpotService;
import mindswap.academy.SchoolProject.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/parkingSpot")
@RestController
public class ParkingSpotController {
        private ParkingSpotService parkingSpotService;

        public ParkingSpotController(ParkingSpotService parkingSpotService) {
            this.parkingSpotService = parkingSpotService;
        }

        @PostMapping
        public ParkingSpot createParkingSpot(@RequestBody ParkingSpot parkingSpot){
            return parkingSpotService.createParkingSpot(parkingSpot);
        }

        @GetMapping
        public List<ParkingSpot> getAllTeachers(){
            return parkingSpotService.getParkingSpotList();
        }
    }


