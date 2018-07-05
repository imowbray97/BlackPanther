package com.panthers.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Characters")
public class BCharacter implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="character_id")
        private long characterId;  
	
	@Column(name="name")
        private String name;
	
	@Column(name="description")	
	private String description;
	
	
	
	public BCharacter() {
		super();
	}
	public long getCharacterId() {
		return characterId;
	}
	public void setCharacterId(long characterId) {
		this.characterId = characterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
} 