package nl.craftsmen.contacts;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ContactsCreateController.RESOURCE)
@AllArgsConstructor
@Slf4j
public class ContactsCreateController {

	static final String RESOURCE = "/contacts";

	private final ContactCreateService contactCreateService;

	@PostMapping()
	@Transactional
	public Mono<Contact> post(@Valid @RequestBody Contact contact) {
		log.info(">>>>> Resource /contacts create called");
		return contactCreateService.create(contact);
	}
}
