package com.andreasekman.person.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.andreasekman.person.entity.Person;

public class DeleteAllPersons {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
	
		Query query = entitymanager.createQuery("DELETE FROM Person");
		int rowCount = query.executeUpdate();
		
		System.out.println(rowCount);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
