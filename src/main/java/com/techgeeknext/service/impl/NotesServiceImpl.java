package com.techgeeknext.service.impl;
import java.util.List;

import javax.validation.Valid;

import com.techgeeknext.modal.NoteBase;
import com.techgeeknext.modal.Notes;
import com.techgeeknext.modal.User;
import com.techgeeknext.repository.NotesRepository;
import com.techgeeknext.repository.UserRepository;
import com.techgeeknext.service.NotesService;
import com.techgeeknext.util.ApplicationConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesServiceImpl implements NotesService {
	private static final Logger log = LogManager.getLogger(NotesServiceImpl.class);

	@Autowired
	private NotesRepository noteRepository;

	@Override
	public String addNote(Notes note){
		log.info("Inside add note service");
		noteRepository.save(note);
		log.info("Successfully added new Note.");
		return ApplicationConstants.ADDED_NOTE_DESC;
	}
}
