package com.spring.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.spring.main.model.Student;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	SchoolYr INT NOT NULL,
//  Campus VARCHAR(100) NOT NULL,
//  StudentID INT NOT NULL,
//  EntryDate DATE NOT NULL,
//  GradeLevel INT NOT NULL,
//  Name VARCHAR(100) NOT NULL

	public void saveOrUpdate(Student student) {
		if (student.getStudentID() > 0) {
			// update student
			String sql = "UPDATE students SET schoolYr=?, campus=?, entryDate=?, gradeLevel=?, name=? WHERE studentID=?";

			jdbcTemplate.update(sql, student.getSchoolYr(), student.getCampus(), student.getEntryDate(),
					student.getGradeLevel(), student.getName(), student.getStudentID());

		} else {
			// insert student
			String sql = "INSERT INTO students (schoolYr, campus, entryDate, gradeLevel, name) VALUES (?, ?, ?, ?, ?)";

			jdbcTemplate.update(sql, student.getSchoolYr(), student.getCampus(), student.getEntryDate(),
					student.getGradeLevel(), student.getName());

		}

	}

	public void delete(int studentID) {
		String sql = "DELETE FROM students where studentID=?";
		jdbcTemplate.update(sql, studentID);

	}

	public Student get(int studentID) {
		String sql = "SELECT * FROM students WHERE studentID=" + studentID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Student student = new Student();
					student.setStudentID(rs.getInt("studentID"));
					student.setSchoolYr(rs.getInt("schoolYr"));
					student.setCampus(rs.getString("campus"));
					student.setEntryDate(rs.getString("entryDate"));
					student.setGradeLevel(rs.getInt("gradeLevel"));
					student.setName(rs.getString("name"));
					return student;
				}

				return null;
			}
		});
	}

//	SchoolYr INT NOT NULL,
//  Campus VARCHAR(100) NOT NULL,
//  StudentID INT NOT NULL,
//  EntryDate DATE NOT NULL,
//  GradeLevel INT NOT NULL,
//  Name VARCHAR(100) NOT NULL

	public List<Student> list() {
		String sql = "SELECT * FROM students";
		List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student aStudent = new Student();

				aStudent.setStudentID(rs.getInt("studentID"));
				aStudent.setSchoolYr(rs.getInt("schoolYr"));
				aStudent.setCampus(rs.getString("campus"));
				aStudent.setEntryDate(rs.getString("entryDate"));
				aStudent.setGradeLevel(rs.getInt("gradeLevel"));
				aStudent.setName(rs.getString("name"));

				return aStudent;
			}
		});

		return listStudent;
	}
}
