package academits.phonebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import academits.model.Contact;
import academits.model.ContactValidation;
import academits.service.ContactService;

import java.util.List;

@Controller
@RequestMapping("/phoneBook/rpc/api/v1")
public class PhoneBookController {
    private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    private final ContactService contactService;

    public PhoneBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "getAllContacts", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getAllContacts(String filter) {
        logger.info("called method getAllContacts");
        return contactService.getAllContacts(filter);
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    @ResponseBody
    public ContactValidation addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @RequestMapping(value = "deleteContact", method = RequestMethod.POST)
    @ResponseBody
    public void deleteContact(int id) {
        contactService.deleteContact(id);
    }
}


