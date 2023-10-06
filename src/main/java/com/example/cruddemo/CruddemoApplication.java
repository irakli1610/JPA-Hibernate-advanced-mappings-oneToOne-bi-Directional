package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return  runner ->
		{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 5;
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 5;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println(instructorDetail);

		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleteing instructor with id "+ theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId= 3;
		System.out.println("finding instructor with id "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associate instructor "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		//create instructor
//		Instructor tempInstructor =
//				new Instructor("Rezo","Mamaladze", "rezo@gmail.com");
//
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("http://www.youtube.com/youtube","code");


		Instructor tempInstructor =
				new Instructor("Ahmed","Sheleby", "ahmed@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.kinder.com/kind","play");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor"+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");

	}

}
