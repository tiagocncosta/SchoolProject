package mindswap.academy.SchoolProject.command.parkingSpot;

import mindswap.academy.SchoolProject.model.ParkingSpot;

public class ParkingSpotConverter {
    public static ParkingSpotDto convertToDto(ParkingSpot parkingSpot){
        return ParkingSpotDto.builder()
                .id(parkingSpot.getId())
                .teacher(parkingSpot.getTeacher())
                .build();
    }

    public static ParkingSpot convertToEntity(ParkingSpotDto parkingSpotDto){
        return ParkingSpot.builder()
                .id(parkingSpotDto.getId())
                .build();
    }

    public static ParkingSpot convertCreateParkingSpotToEntity(CreateParkingSpotDto createParkingSpotDto){
        return ParkingSpot.builder()
                .build();
    }
}
