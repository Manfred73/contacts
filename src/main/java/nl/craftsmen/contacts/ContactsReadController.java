package nl.craftsmen.contacts;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ContactsReadController.RESOURCE)
@AllArgsConstructor
@Slf4j
public class ContactsReadController {

    static final String RESOURCE = "/contacts";

    private final ContactReadService contactReadService;

    @GetMapping("/{id}")
    public Mono<Contact> get(@PathVariable("id") Long id) {
        log.info(">>>>> Resource /contacts/{} called", id);
        return contactReadService.findById(id);
    }

    @GetMapping()
    public Flux<Contact> getByCriteria(
            @RequestParam("firstname") Optional<String> firstName,
            @RequestParam("lastname") Optional<String> lastName,
            @RequestParam("socialsecuritynumber") Optional<String> socialSecurityNumber,
            @RequestParam("iban") Optional<String> iban) {
        log.info(">>>>> Resource /contacts getByCriteria called with firstname {}, lastname {}, "
                + "socialsecuritynumber {}, iban {}", firstName, lastName, socialSecurityNumber, iban);

        // Map all incoming request parameters to search criteria model.
        final var searchCriteria = ContactSearchCriteria.builder()
                .firstName(firstName.orElse(null))
                .lastName(lastName.orElse(null))
                .socialSecurityNumber(socialSecurityNumber.orElse(null))
                .iban(iban.orElse(null)).build();
        return contactReadService.findByCriteria(searchCriteria);
    }
}
