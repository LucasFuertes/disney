package com.alkemy.disney.disney.Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Movie")
@Getter
@Setter
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String image;
	
	private String title;
	
	@Column(name = "creation_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate creationDate;
	
	private Short qualification;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "gender_id", insertable = false, updatable = false)
	private GenderEntity gender;
	
	@Column(name = "gender_id", nullable = false)
	private Long genderId;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
			})
	@JoinTable(
			name = "character_movie",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id"))
	private Set<CharacterEntity> character = new HashSet<>();
}
