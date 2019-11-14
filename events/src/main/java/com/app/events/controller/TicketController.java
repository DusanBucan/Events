package com.app.events.controller;

import java.security.Principal;

import com.app.events.dto.TicketDTO;
import com.app.events.mapper.TicketMapper;
import com.app.events.model.Ticket;
import com.app.events.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController extends BaseController {

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/api/tickets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") Long id) {
		Ticket ticket = ticketService.findOne(id);
		if (ticket == null) {
			return new ResponseEntity<TicketDTO>(HttpStatus.NOT_FOUND);
		}
		System.out.println(ticket.toString());
		return new ResponseEntity<TicketDTO>(TicketMapper.toDTO(ticket), HttpStatus.OK);
	}

	@PostMapping(value = "/api/tickets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) throws Exception {
		Ticket savedTicket = ticketService.create(TicketMapper.toTicket(ticketDTO));
		return new ResponseEntity<>(TicketMapper.toDTO(savedTicket), HttpStatus.CREATED);
	}

	@PutMapping(value = "/api/reserveTicket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> reserveTicket(@RequestBody TicketDTO ticketDTO, Principal user) throws Exception {
		Ticket updatedTicket = ticketService.reserveTicket(ticketDTO.getId());
		if (updatedTicket == null) {
			return new ResponseEntity<TicketDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TicketDTO>(TicketMapper.toDTO(updatedTicket), HttpStatus.OK);
	}

	@PutMapping(value = "/api/buyTicket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> buyTicket(@RequestBody TicketDTO ticketDTO) throws Exception {
		Ticket updatedTicket = ticketService.buyTicket(ticketDTO.getId());
		if (updatedTicket == null) {
			return new ResponseEntity<TicketDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TicketDTO>(TicketMapper.toDTO(updatedTicket), HttpStatus.OK);
	}

	@DeleteMapping(value = "/api/tickets/{id}")
	public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") Long id) {
		ticketService.delete(id);
		return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
	}

}
