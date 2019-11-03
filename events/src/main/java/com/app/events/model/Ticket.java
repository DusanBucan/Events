package com.app.events.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String barCode;
	
	@Enumerated(EnumType.STRING)
	private TicketState ticketState;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="event_id", referencedColumnName="id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name="seat_id", referencedColumnName="id")
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name="sector_capacity_id", referencedColumnName="id")
	private SectorCapacity sectorCapacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public TicketState getTicketState() {
		return ticketState;
	}

	public void setTicketState(TicketState ticketState) {
		this.ticketState = ticketState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public SectorCapacity getSectorCapacity() {
		return sectorCapacity;
	}

	public void setSectorCapacity(SectorCapacity sectorCapacity) {
		this.sectorCapacity = sectorCapacity;
	}
	
	
	
}