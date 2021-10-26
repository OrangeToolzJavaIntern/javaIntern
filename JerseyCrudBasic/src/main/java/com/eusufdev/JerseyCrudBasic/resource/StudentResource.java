package com.eusufdev.JerseyCrudBasic.resource;

import java.util.List;

import com.eusufdev.JerseyCrudBasic.model.Student;
import com.eusufdev.JerseyCrudBasic.repository.StudentRepository;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	StudentRepository studentrepository = new StudentRepository();

	@GET
	@Path("getallstudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getstudent() {
		System.out.println("Student Called.....");

		return studentrepository.getstudent();
	}

	@GET
	@Path("getallstudents/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") int id) {

		return studentrepository.getstudent(id);

	}

	@POST
	@Path("insertstudent")
	@Produces(MediaType.APPLICATION_JSON)
	public String createstudent(Student s) {

		studentrepository.create(s);
		return "Succesfully Inserted";
	}

	@PUT
	@Path("updatestudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updatestudent(Student s) {

		if (studentrepository.getstudent(s.getId()).getId() == 0) {
			studentrepository.create(s);
		} else {
			studentrepository.update(s);
		}

		return "Succesfully Updated";
	}

	@DELETE
	@Path("deletestudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteStudent(@PathParam("id") int id) {

		Student student = studentrepository.getstudent(id);
		if (student.getId() != 0)
			studentrepository.delete(id);

		return "Delete Successfully";

	}

}
