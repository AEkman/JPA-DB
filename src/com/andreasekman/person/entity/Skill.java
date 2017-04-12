package com.andreasekman.person.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String skillName;
	
	@OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL, orphanRemoval=true)
	private List skillsList;

	public Skill() {
		super();
	}
	
	// Getters/Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List skillsList) {
		this.skillsList = skillsList;
	}
}
