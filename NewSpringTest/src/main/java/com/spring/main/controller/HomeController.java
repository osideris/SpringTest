package com.spring.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.dao.StudentDAO;
import com.spring.main.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value="/newStudent", method = RequestMethod.GET)
	public ModelAndView newStudent(ModelAndView model) {
		Student newStudent = new Student();
		model.addObject("student", newStudent);
		model.setViewName("StudentForm");
		return model;
	}
	
	@RequestMapping(value="/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		studentDAO.saveOrUpdate(student);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		studentDAO.delete(studentID);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		Student student = studentDAO.get(studentID);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("student", student);
		
		return model;
	}

	@RequestMapping(value="/")
	public ModelAndView listStudent(ModelAndView model) throws IOException{
		List<Student> listStudent = studentDAO.list();
		model.addObject("listStudent", listStudent);
		model.setViewName("home");
		
		
		return model;
	}
}
