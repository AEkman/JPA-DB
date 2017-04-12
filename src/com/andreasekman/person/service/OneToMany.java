package com.andreasekman.person.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.andreasekman.person.entity.Person;
import com.andreasekman.person.entity.Skill;

public class OneToMany {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		// Create person 1 entity
		Person person1 = new Person();
		person1.setFirstName("Göran");
		person1.setLastName("Pärsson");
		
		// Create person 2 entity
		Person person2 = new Person();
		person2.setFirstName("Johannes");
		person2.setLastName("Skog");
		
		// Create person 2 entity
		Person person3 = new Person();
		person3.setFirstName("Sandra");
		person3.setLastName("Nilsson");
		
		// Store persons
		entitymanager.persist(person1);
		entitymanager.persist(person2);
		entitymanager.persist(person3);
		
		// Create list of Persons
		List<Person> personList = new ArrayList();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		
		// Create skill Entity
		Skill skills = new Skill();
		skills.setSkillName("Hacker");
		skills.setSkillsList(personList);
		
		// Store skills
		entitymanager.persist(skills);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
