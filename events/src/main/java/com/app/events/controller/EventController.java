package com.app.events.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.events.dto.EventDTO;
import com.app.events.exception.ResourceNotFoundException;
import com.app.events.mapper.EventMapper;
import com.app.events.model.Event;
import com.app.events.model.Hall;
import com.app.events.model.Media;
import com.app.events.service.EventService;
import com.app.events.service.MediaService;
import com.app.events.service.TicketService;

@RestController
public class EventController extends BaseController{
	
	@Autowired
	private EventService eventService;

	@Autowired
	private MediaService mediaService;
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping(value = "/api/event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventDTO> getEvent(@PathVariable("id") Long id) throws ResourceNotFoundException{
		Event event = eventService.findOne(id);
		return new ResponseEntity<>(EventMapper.toDTO(event), HttpStatus.OK);
	}

	@PostMapping(value = "/api/event", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) throws Exception {
		Event event = EventMapper.toEvent(eventDTO);
		Set<Media> mediaList = event.getMediaList();
		Set<Hall> halls = event.getHalls();
		Event savedEvent = eventService.create(event);
		mediaService.createMedias(mediaList, savedEvent.getId());
		ticketService.createTickets(halls, savedEvent.getId());
		return new ResponseEntity<>(EventMapper.toDTO(savedEvent), HttpStatus.CREATED);
	}


	@PutMapping(value = "/api/event", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO eventDTO) throws Exception {
		Event updatedEvent = eventService.update(EventMapper.toEvent(eventDTO));
		return new ResponseEntity<>(EventMapper.toDTO(updatedEvent), HttpStatus.OK);
	}

	@DeleteMapping(value = "/api/event/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<EventDTO> deleteEvent(@PathVariable("id") Long id) {
		eventService.delete(id);
		return new ResponseEntity<EventDTO>(HttpStatus.NO_CONTENT);
	}

}
