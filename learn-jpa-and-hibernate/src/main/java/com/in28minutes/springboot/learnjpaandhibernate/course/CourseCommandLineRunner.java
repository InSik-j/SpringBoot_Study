package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
//		repository.insert(new Course(1, "Learn AWS JPA!", "in28minutes"));
//		repository.insert(new Course(2, "Learn Azure JPA!", "in28minutes"));
//		repository.insert(new Course(3, "Learn DevOps JPA!", "in28minutes"));
		
		repository.save(new Course(1, "Learn AWS JPA!", "in28minutes"));
		repository.save(new Course(2, "Learn Azure JPA!", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps JPA!", "in28minutes"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println( repository.findAll()); // findAll() : select * from Course와 같음
		System.out.println( repository.count());
		
		System.out.println( repository.findByAuthor("in28minutes"));
		System.out.println( repository.findByAuthor(""));
		
		System.out.println( repository.findByName("Learn DevOps JPA!"));
		System.out.println( repository.findByName("Learn Azure JPA!"));
	}
	
}
