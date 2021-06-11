package com.spring.mongodb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import com.spring.mongodb.Controller.StudentController;
import com.spring.mongodb.Repositories.StudentRepositories;
import com.spring.mongodb.model.Student;
@SpringBootTest
class SpringJpaApplicationTests {
	@MockBean
	private StudentRepositories repositories;
	@Test
	public void savetest() {
		Student student=new Student(1,"Harsha","harsha1");
		when(repositories.save(student)).thenReturn(student);
		Assert.assertEquals(1,student.getId());
	}
	@Test
	public void getalltest() {
		List<Student> student=new ArrayList<Student>();
		Student st=new Student(2,"chandra","chandra2");
		Student st1=new Student(3,"manideep","manideep3");
		student.add(st);
		student.add(st1);
		when(repositories.findAll()).thenReturn(student);
	}
}