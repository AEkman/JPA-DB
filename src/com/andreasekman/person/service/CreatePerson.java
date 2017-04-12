package com.andreasekman.person.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.andreasekman.person.entity.Person;

public class CreatePerson {

   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );

      Person person = new Person( ); 
      person.setPid(2);
      person.setFirstName("Gittan" );
      person.setLastName("Svensson");
      
      entitymanager.persist(person);
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
   }
}
