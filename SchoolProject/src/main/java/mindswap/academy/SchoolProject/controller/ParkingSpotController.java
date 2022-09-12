package mindswap.academy.SchoolProject.controller;

import mindswap.academy.SchoolProject.command.parkingSpot.CreateParkingSpotDto;
import mindswap.academy.SchoolProject.command.parkingSpot.ParkingSpotDto;
import mindswap.academy.SchoolProject.service.ParkingSpotService;
import mindswap.academy.SchoolProject.service.ParkingSpotServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/parkingSpot")
@RestController
public class ParkingSpotController {
        private ParkingSpotService parkingSpotService;

        public ParkingSpotController(ParkingSpotService parkingSpotService){
            this.parkingSpotService = parkingSpotService;
        }

        @PostMapping
        public ResponseEntity<ParkingSpotDto> createParkingSpot(@RequestBody CreateParkingSpotDto parkingSpot){
           if(parkingSpot==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(parkingSpotService.createParkingSpot(parkingSpot), HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<ParkingSpotDto>> getAllParkingSpotDtos(){
            return new ResponseEntity<>(parkingSpotService.getParkingSpotList(), HttpStatus.OK);
        }

        @GetMapping("/{idParkingSpot}")
        public ResponseEntity<ParkingSpotDto> getParkingSpotDtoById(@PathVariable Integer idParkingSpot){
            return new ResponseEntity<>(parkingSpotService.getParkingSpotDtoById(idParkingSpot), HttpStatus.OK);
        }
       @PutMapping("/{idParkingSpot}/{idTeacher}")
        public ResponseEntity<ParkingSpotDto> addTeacherToParkingSpot(@PathVariable Integer idParkingSpot,@PathVariable Integer idTeacher){
            return new ResponseEntity<>(parkingSpotService.addTeacherToParkingSpot(idParkingSpot, idTeacher), HttpStatus.OK);
        }


    }






