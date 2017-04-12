package com.andreasekman.person.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.andreasekman.person.entity.Person;

public class FindingPerson {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      Person person = entitymanager.find( Person.class, 2);
	      
	      System.out.println("Person ID = " + person.getPid());
	      System.out.println("Person FIRSTNAME = " + person.getFirstName());
	      System.out.println("Person LASTNAME = " + person.getLastName());
	      System.out.println("Person SKILLS = " + person.getSkills());
	}
}