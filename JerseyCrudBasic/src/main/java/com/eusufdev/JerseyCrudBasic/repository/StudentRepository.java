package com.eusufdev.JerseyCrudBasic.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eusufdev.JerseyCrudBasic.model.Student;

public class StudentRepository {

	Connection connection = null;

	public StudentRepository() {

		String url = "jdbc:mysql://localhost:3306/studentrestdb";
		String username = "root";
		String password = "Eusuf171158926";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {

				System.out.println(e);
			}
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {

			System.out.println(e);
		}
	}

	public List<Student> getstudent() {
		List<Student> studentslist = new ArrayList<Student>();
		String sql = "select * from student";

		try {
			Statement st = connection.createStatement();
			ResultSet rS = st.executeQuery(sql);

			while (rS.next()) {
				Student student = new Student();
				student.setId(rS.getInt(1));
				student.setFname(rS.getString(2));
				student.setLname(rS.getString(3));
				student.setEmail(rS.getString(4));
				student.setMessage(rS.getString(5));

				studentslist.add(student);

			}

		} catch (SQLException e) {

			System.out.println(e);
		}

		return studentslist;
	}

	public Student getstudent(int id) {

		String sql = "select * from student where id=" + id;
		Student student = new Student();

		try {
			Statement st = connection.createStatement();
			ResultSet rS = st.executeQuery(sql);

			if (rS.next()) {

				student.setId(rS.getInt(1));
				student.setFname(rS.getString(2));
				student.setLname(rS.getString(3));
				student.setEmail(rS.getString(4));
				student.setMessage(rS.getString(5));

			}

		} catch (SQLException e) {

			System.out.println(e);
		}

		return student;

	}

	public void create(Student student) {

		String sql = "insert into student values (?,?,?,?,?)";

		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, student.getId());
			st.setString(2, student.getFname());
			st.setString(3, student.getLname());
			st.setString(4, student.getEmail());
			st.setString(5, student.getMessage());
			st.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e);
		}

	}

	public void update(Student student) {

		String sql = "update student set fname=?, lname=?, email=?, message=? where id=?";

		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, student.getFname());
			st.setString(2, student.getLname());
			st.setString(3, student.getEmail());
			st.setString(4, student.getMessage());
			st.setInt(5, student.getId());
			st.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e);
		}

	}

	public void delete(int id) {
		String sql = "delete from student where id=?";

		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e);
		}

	}

}
