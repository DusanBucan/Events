package com.app.events.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.events.dto.HallDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotBlank(message = "Name can not be empty string")
	private String name;
	
	@NotNull(message = "Hall must be asociated with place")
	@ManyToOne
	@JoinColumn(name="place_id", referencedColumnName="id")
	private Place place;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Sector> sectors;
	
	@ManyToMany(mappedBy = "halls")
	private Set<Event> events;
	
	public Hall(HallDTO hall) {
	    this.id = hall.getId();
	    this.name = hall.getName(); 
	}

	public Hall(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	
	public Hall(Long id){
		this.id = id;
	}
}
