package com.k15t.pat.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.k15t.pat.domain.Registration;
import com.k15t.pat.exception.CustomGenericException;
import com.k15t.pat.service.RegistrationService;

/**
 * This controller is the Rest Controller API
 * 
 * @author Mahidhar
 *
 */

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	/**
	 * This method returns the list of all stored registrations
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Registration> list() {
		return registrationService.list();
	}

	/**
	 * This method inserts a new registration entry in the database
	 * 
	 * @param registration
	 * @return instance of Registration
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Registration create(@RequestBody Registration registration) {
		return registrationService.create(registration);
	}

	/**
	 * This method takes the id and returns the matching registration fields
	 * 
	 * @param id
	 * @return instance of Registration
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Registration read(@PathVariable(value = "id") long id) {
		Registration registration = registrationService.read(id);
		if (registration == null) {
			throw new CustomGenericException(null, "registration with id: " + id + " not found.");
		}
		return registration;
	}

	/**
	 * This method takes the id and updates the values with the matched instance
	 * in the database
	 * 
	 * @param id
	 * @param registration
	 * @return instance of Registration
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Registration update(@PathVariable(value = "id") long id, @RequestBody Registration registration) {
		return registrationService.update(id, registration);
	}

	/**
	 * This method takes the id and deletes the matching instance from the
	 * database
	 * 
	 * @param id
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") int id) {
		registrationService.delete(id);
	}

}
