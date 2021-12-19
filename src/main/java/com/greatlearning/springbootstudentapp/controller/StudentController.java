package com.greatlearning.springbootstudentapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.springbootstudentapp.entity.Student;
import com.greatlearning.springbootstudentapp.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

		@Autowired
		private StudentService studentService;

		@RequestMapping("/list")
		public String listStudents(Model model) {
			List<Student> students = studentService.findAll();
			model.addAttribute("Students", students);
			return "list-Students";
		}

		@RequestMapping("/showFormForAdd")
		public String showFormForAdd(Model model) {
			Student student = new Student();
			model.addAttribute( "newStudent", true );
			model.addAttribute("Student", student);
			return "Student-form";
		}

		@RequestMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
			Student student = studentService.findById(id);
			model.addAttribute("Student", student);
			return "Student-form";
		}

		@PostMapping("/save")
		public String saveStudent(
				@RequestParam("id") int id,
				@RequestParam("firstName") String firstname,
				@RequestParam("lastName") String lastname, 
				@RequestParam("department") String department,
				@RequestParam("country") String country) {
			Student student;
			if (id != 0) {
				student = studentService.findById(id);
				student.setFirstName(firstname);
				student.setLastName(lastname);
				student.setDepartment(department);
				student.setCountry(country);
			} else
				student = new Student(firstname, lastname, department,country);

			studentService.save(student);
			return "redirect:/students/list";

		}

		@RequestMapping("/delete")
		public String delete(@RequestParam("studentId") int id) {
			studentService.deleteById(id);
			return "redirect:/students/list";

		}

		@RequestMapping(value = "/403")
		public ModelAndView accesssDenied(Principal user) {
			ModelAndView model = new ModelAndView();

			if (user != null) {
				model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
			} else {
				model.addObject("msg", "You do not have permission to access this page!");
			}

			model.setViewName("403");
			return model;
		}
	
	
}
