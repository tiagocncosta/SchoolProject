package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.model.ParkingSpot;
import mindswap.academy.SchoolProject.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotRepository.findAll();

    }

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }
}
