package com.app.events.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.events.exception.ResourceNotFoundException;
import com.app.events.model.Media;
import com.app.events.repository.EventRepository;
import com.app.events.repository.MediaRepository;
import com.app.events.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	MediaRepository mediaRepository;
	
	@Autowired
	EventRepository eventRepository;

	@Override
	public Media findOne(Long id) throws ResourceNotFoundException {
		return mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media"));
	}

	@Override
	public Collection<Media> findAllForEvent(Long id) {
		return mediaRepository.findAllByEventId(id);
	}

	@Override
	public Media crate(Media media, Long eventId) throws ResourceNotFoundException {
		media.setEvent(eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event")));
		media.setId(null);
		return mediaRepository.save(media);
	}	

	@Override
	public void delete(Long id) throws ResourceNotFoundException  {
		Media media = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media"));
		media.setEvent(null);
		mediaRepository.save(media);
		mediaRepository.deleteById(id);;
	}

	
	
}
