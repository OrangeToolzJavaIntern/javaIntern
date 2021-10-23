package com.example.JerseyCrudDemo.daoclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.JerseyCrudDemo.model.Student;

public class Studentdao {

	List<Student> studentslist;

	public Studentdao() {

		studentslist = new ArrayList<Student>();

		Student student1 = new Student(1, "Ashiqul Aziz");
		Student student2 = new Student(2, "Siam");
		Student student3 = new Student(3, "Imrul Hasan");

		studentslist.addAll(Arrays.asList(student1, student2, student3));

	}
	
	
	

	public List<Student> getallStudents() {

		return studentslist;
	}
	
	
	
	
	// GET Method to GET Student Informations
	public Student getstudentbyId(int sid) {

		return studentslist.stream().filter(x->x.getsId()==sid)
				.collect(Collectors.toList()).get(0);
	}
	
	
	// GET Method to GET Student Informations
		public List<Student> getstudentbyIdandName(int sid, String name) {

			studentslist.stream().filter(x->x.getsId()==sid)
			                     .filter(x->x.getName()==name)
					.collect(Collectors.toList()).get(0);
		
			
			
			return studentslist;
		}
		
	
	
	
	// Insert Method to Insert Student Informations

	public List<Student> insertStudents(Student st) {

	
		studentslist.add(st);
		return studentslist;
	}
	
	
	
	
	// Remove Method to remove Student Informations
	public List<Student> removeStudent(int id) {

		studentslist.removeIf(x ->x.getsId()== id );//? "Record is Deleted Successfully" : "failed"
	
		return studentslist;
	}
	
	
	

	// Update Method to Update Student Informations
	
	public List<Student> updateStudent(int id, String name) {


		studentslist.stream().filter(x->x.getsId()==id)
		.collect(Collectors.toList()).get(0).setName(name);
		return studentslist;
	}
	

}
