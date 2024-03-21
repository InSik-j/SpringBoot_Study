package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// JPA : 기술 명세를 정의. API로 인터페이스와 유사
//       Entity 정의, attribute (속성) 매핑, EntityManager 활용이 가능
//        -Entity가 무엇인지 정의하는 방식을 정의
//		  -jakarta.persistence.id를 사용하여 기본키 정의
//        -@Column을 사용하여 속성 매핑


@Repository
@Transactional // JPA로 쿼리를 실행할 때마다 트랜잭션을 허용
public class CourseJpaRepository {
	
	@PersistenceContext // @Autowired보다 더 구체적인 어노테이션 
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);;
	}
}
