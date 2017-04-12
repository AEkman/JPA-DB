package com.andreasekman.person.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.andreasekman.person.entity.Person;

public class UpdatingPerson {

   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );

      Person person = entitymanager.find(Person.class, 2);
      
      // Before update
      System.out.println(person);
      
      // Update
      person.setFirstName("Gösta");
      person.setLastName("Ekman");
      entitymanager.getTransaction().commit();
      
      // After update
      System.out.println(person);
      entitymanager.close();
      emfactory.close();
   }
}
