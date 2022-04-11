package com.alkemy.disney.disney.Entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Gender")
@Getter
@Setter
public class GenderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String image;
}
