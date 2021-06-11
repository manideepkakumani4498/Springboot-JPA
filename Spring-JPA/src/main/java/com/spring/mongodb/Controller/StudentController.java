package com.spring.mongodb.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.Repositories.StudentRepositories;
import com.spring.mongodb.model.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentRepositories repositories;
	
	@PostMapping("add")
	public String add(@RequestBody Student student) {
		repositories.save(student);
		return "student record saved:"+student.getId();
	}
	@GetMapping("getall")
	public List<Student> getall(){
		return (List<Student>) repositories.findAll();
	}
	@GetMapping("getbyid/{id}")
	public Optional<Student> getbyid(@PathVariable int id){
		return repositories.findById(id);	
	}
	@PutMapping("update")
	public String update(@RequestBody Student student) {
		repositories.save(student);
		return "student recored updated:"+student.getId();
	}
	@DeleteMapping("deletebyid")
	public void deletebyid(@PathVariable int id) {
		repositories.deleteById(id);
	}
	@DeleteMapping
	public void deleteall() {
		repositories.deleteAll();
	}
	

}
