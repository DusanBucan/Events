package com.app.events.service;

import java.util.Set;

import com.app.events.exception.ResourceNotFoundException;
import com.app.events.model.Hall;
import com.app.events.model.Ticket;

public interface TicketService {

	public Ticket findOne(Long id) throws ResourceNotFoundException;

	public Ticket create(Ticket ticket) throws Exception;

	public Ticket reserveTicket(Long id, Long userId, Long ticketVersion) throws Exception;

	public Ticket buyTicket(Long id, Long userId) throws Exception;

	public void delete(Long id);

	public void createTickets(Set<Hall> halls, Long eventId) throws ResourceNotFoundException, Exception;

}
