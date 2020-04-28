package com.techgeeknext.service.impl;

import com.techgeeknext.modal.Notes;
import com.techgeeknext.modal.User;
import com.techgeeknext.service.NotesService;
import com.techgeeknext.service.UserNotesLinkService;
import com.techgeeknext.service.UserService;
import com.techgeeknext.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserNotesLinkServiceImpl implements UserNotesLinkService {
    @Autowired
    private UserService userService;

    @Autowired
    private NotesService notesService;

    @Override
    @Transactional
    public String addNoteToSpecificUser(User user, Notes note) throws Exception {
        //create new user
        User createdUser = userService.registerUser(user);
        Notes dbNote = new Notes();
        dbNote.setTitle(note.getTitle());
        dbNote.setMessage(note.getMessage());
        //set created user to note
        dbNote.setUserDetails(createdUser);
        //persist new note
        notesService.addNote(dbNote);
        return ApplicationConstants.ADDED_NOTE_DESC;
    }
}
