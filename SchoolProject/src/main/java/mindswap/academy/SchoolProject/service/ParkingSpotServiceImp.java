package mindswap.academy.SchoolProject.service;

import mindswap.academy.SchoolProject.command.parkingSpot.CreateParkingSpotDto;
import mindswap.academy.SchoolProject.command.parkingSpot.ParkingSpotConverter;
import mindswap.academy.SchoolProject.command.parkingSpot.ParkingSpotDto;
import mindswap.academy.SchoolProject.model.ParkingSpot;
import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingSpotServiceImp implements ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;
    private TeacherServiceImp teacherServiceImp;

    public ParkingSpotServiceImp(ParkingSpotRepository parkingSpotRepository, TeacherServiceImp teacherServiceImp) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.teacherServiceImp = teacherServiceImp;
    }

    @Override
    public List<ParkingSpotDto> getParkingSpotList() {

        return parkingSpotRepository.findAll().stream()
                .map(parkingSpot -> ParkingSpotConverter.convertToDto(parkingSpot))
                .collect(Collectors.toList());

    }

    @Override
    public ParkingSpotDto createParkingSpot(CreateParkingSpotDto parkingSpot) {
        return ParkingSpotConverter.convertToDto(parkingSpotRepository.save(ParkingSpotConverter.convertCreateParkingSpotToEntity(parkingSpot)));
    }

    @Override
    public ParkingSpotDto addTeacherToParkingSpot(Integer idParkingSpot, Integer idTeacher) {
        Teacher teacher = teacherServiceImp.getTeacherEntityById(idTeacher);
        ParkingSpot parkingSpot = parkingSpotRepository.findById(idParkingSpot).get();
        teacher.setParkingSpot(parkingSpot);
        parkingSpot.setTeacher(teacher);
        return ParkingSpotConverter.convertToDto(parkingSpotRepository.save(parkingSpot));
    }

    @Override
    public ParkingSpotDto getParkingSpotDtoById(Integer id) {
        return ParkingSpotConverter.convertToDto(getParkingSpotEntityById(id));
    }
    @Override
    public ParkingSpot getParkingSpotEntityById(Integer id){
        return parkingSpotRepository.findById(id).get();
    }
}
