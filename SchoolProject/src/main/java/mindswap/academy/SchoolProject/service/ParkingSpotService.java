package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.command.parkingSpot.CreateParkingSpotDto;
import mindswap.academy.SchoolProject.command.parkingSpot.ParkingSpotDto;
import mindswap.academy.SchoolProject.model.ParkingSpot;

import java.util.List;

public interface ParkingSpotService {
    List<ParkingSpotDto> getParkingSpotList();

    ParkingSpotDto createParkingSpot(CreateParkingSpotDto parkingSpot);

    ParkingSpotDto addTeacherToParkingSpot(Integer idParkingSpot, Integer idTeacher);

    ParkingSpotDto getParkingSpotDtoById(Integer id);

    ParkingSpot getParkingSpotEntityById(Integer id);
}
