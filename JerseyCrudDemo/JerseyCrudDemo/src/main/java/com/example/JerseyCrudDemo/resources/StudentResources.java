package com.example.JerseyCrudDemo.resources;


import java.util.List;

import com.example.JerseyCrudDemo.daoclass.Studentdao;
import com.example.JerseyCrudDemo.model.Student;


import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResources {
	
	// Create Instance of studentdao class
	Studentdao studentdao = new Studentdao();
	
	
	// Using Simple @GET Request
	@GET
	@Path("getAllStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent() {

		return studentdao.getallStudents();
		
	}
	
	
	
	// Using @Pathparam to GET Operations
	@GET
	@Path("getStudents/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("id") int id) {

		return studentdao.getstudentbyId(id);
		
	}
	
	
	
    // Using @QueryParam to GET Operations
	@GET
	@Path("getStudentQuery")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByQuery(@QueryParam("id") int id){

		return studentdao.getstudentbyId(id);
		
	}
	
	

	// Normal POST Operation
	@POST
	@Path("insertStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> insertStudent(Student student) {

		return studentdao.insertStudents(student);
		
	}
	
	
	
	 // Using @FormParam to Post Operations
	@POST
	@Path("insertStudentusingForm")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> insertStudent(@FormParam("id") int id, 
			@FormParam("name") String name) {


		Student student = new Student(id,name);
		return studentdao.insertStudents(student);
		
	}
	

	
	// Using @PathParam to DELETE Operations
	@DELETE
	@Path("removeStudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> removeStudent(@PathParam("id") int sid) {

		return studentdao.removeStudent(sid);
		
	}
	
	
	
	// Using @QueryParam to DELETE Operations
		@DELETE
		@Path("removeStudentquery")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Student> removeStudentusingQuery(@QueryParam("id") int id) {

			return studentdao.removeStudent(id);
			
		}
	
		
	// Using @FormParam to DELETE Operations
		@DELETE
		@Path("removeStudentform")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Student> removeStudentusingForm(@FormParam("id") int id) {
	
		return studentdao.removeStudent(id);
						
	}
				
	
	
	
	// Using @PathParam to PUT Operations
	
	@PUT
	@Path("updateStudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> updateStudents(@PathParam("id") int sid, Student student) {

		return studentdao.updateStudent(sid, student.getName());
		
	}
	
	
	  // Using @QueryParam to PUT Operations
	  
	  @PUT
	  
	  @Path("updateStudentquery")
	  
	  @Produces(MediaType.APPLICATION_JSON) 
	  public List<Student> updateStudentsQuery(@QueryParam("id") int sid, Student student) {
	 
	  return studentdao.updateStudent(sid, student.getName());
	  
	  }
	  
	  
	  
	// Using @FormParam to PUT Operations
	  
		  @PUT
		  
		  @Path("updateStudentform")
		  
		  @Produces(MediaType.APPLICATION_JSON) 
		  public List<Student> updateStudentsForm(@FormParam("id") int sid, Student student) {
		 
		  return studentdao.updateStudent(sid, student.getName());
		  
		  }
	 
	
}
