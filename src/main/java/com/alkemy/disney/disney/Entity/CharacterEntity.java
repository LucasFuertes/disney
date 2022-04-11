package com.alkemy.disney.disney.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Character")
@Getter
@Setter
public class CharacterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String image;
	
	private String name;
	
	private int age;
	
	private int weight;
	
	private String history;
	
	@ManyToMany(mappedBy = "character", cascade = CascadeType.ALL)
	private List<MovieEntity> movie = new ArrayList<>();
}
