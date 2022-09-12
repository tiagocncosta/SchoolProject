package mindswap.academy.SchoolProject;

import mindswap.academy.SchoolProject.model.Teacher;
import mindswap.academy.SchoolProject.model.Vehicles;
import mindswap.academy.SchoolProject.repository.TeacherRepository;
import mindswap.academy.SchoolProject.repository.VehiclesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class SchoolProjectApplication {
/*	private final TeacherRepository teacherRepository;
	private final VehiclesRepository vehiclesRepository;

	public SchoolProjectApplication(TeacherRepository teacherRepository, VehiclesRepository vehiclesRepository) {
		this.teacherRepository = teacherRepository;
		this.vehiclesRepository = vehiclesRepository;
	}*/
	TeacherRepository teacherRepository;

	public SchoolProjectApplication(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SchoolProjectApplication.class, args);
	}

	@PostConstruct //depois da aplicação arrancar, vou inicializar este init
	public void init() {

		List<Teacher> teacherlist = teacherRepository.findUserByNameList("Diogo");
		for (Teacher teacher: teacherlist){
			System.out.println(teacher.getName());
		}
		/*
		Teacher teacher = Teacher.builder()
				.id(1)
				.name("Tiago")
				.subject("Math")
				.build();

		Vehicles vehicles = Vehicles.builder()
				.id(1)
				.brand("Mercedes")
				.fuel("gas")
				.model("class A")
				.build();

		teacherRepository.save(teacher);
		vehicles.setTeacher(teacher);
		vehiclesRepository.save(vehicles);
		//teacher.setVehicles(vehicles);
		//System.out.println(teacherRepository.save(teacher));

	}*/
	}
}
