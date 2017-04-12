package com.andreasekman.person.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.andreasekman.person.entity.Person;

public class FindAll {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		   EntityManager entitymanager = emfactory.createEntityManager( );
		   CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		   CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		   Root<Person> from = criteriaQuery.from(Person.class);

		   // Select all records
		   System.out.println("Select all records");
		   CriteriaQuery<Object> select = criteriaQuery.select(from);
		   TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		   List<Object> resultlist = typedQuery.getResultList();

		   for(Object o:resultlist) {
		      Person p = (Person)o;
		      System.out.println("PID : " + p.getPid() + " First Name : " + p.getFirstName() + " Last Name : " + p.getLastName());
		   }

		   //Ordering the records 
		   System.out.println("Select all records by follow ordering");
		   CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		   select1.orderBy(criteriaBuilder.asc(from.get("firstName")));
		   TypedQuery<Object> typedQuery1 = entitymanager.createQuery(select);
		   List<Object> resultlist1 = typedQuery1.getResultList();

		   for(Object o:resultlist1){
		      Person p=(Person)o;
		      System.out.println("PID : " + p.getPid() + " First Name : " + p.getFirstName() + " Last Name : " + p.getLastName());
		   }

		   entitymanager.close( );
		   emfactory.close( );
	      
	}
}