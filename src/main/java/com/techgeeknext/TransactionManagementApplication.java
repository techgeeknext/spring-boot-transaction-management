package com.techgeeknext;

import com.techgeeknext.modal.Notes;
import com.techgeeknext.modal.User;
import com.techgeeknext.service.UserNotesLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
@RestController
public class TransactionManagementApplication {

	@Autowired
	private UserNotesLinkService userNotesService;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(TransactionManagementApplication.class, args);
		UserNotesLinkService userNotesLinkService = context.getBean(UserNotesLinkService.class);

		/* TEST DATA FOR TRANSACTION MANAGEMENT EXAMPLE*/
		// create new user
		User user = new User();
		user.setUserMail("techgeeknext@gmail.com");
		user.setUserPass("12345678jhg");

		//create new note
		Notes note = new Notes();
		note.setTitle("Test Note");
		note.setMessage("Test Message");

		//link above new user with above note
		userNotesLinkService.addNoteToSpecificUser(user, note);
	}
}