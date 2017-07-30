package com.k15t.pat.registration;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.k15t.pat.ApplicationBootstrap;
import com.k15t.pat.domain.Registration;

/**
 * RegistrationControllerIT is an integration test. This test class tests all
 * the methods from Rest API
 * 
 * @author Mahidhar
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationControllerIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Before
	public void before() {

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	/**
	 * retrieveRegistration retrieves the specific registration and asserts the value
	 * 
	 * @throws Exception
	 */
	@Test
	public void retrieveRegistration() throws Exception {

		ResponseEntity<Registration> response = restTemplate.getForEntity(createPort("/registrations/1"),
				Registration.class);
		assertTrue(response.getBody().getName().equals("Will"));
	}

	/**
	 * retrieveAllRegistrations  retrieves  all the registrations and asserts the initial
	 * two Registration values
	 * 
	 * @throws Exception
	 */
	@Test
	public void retrieveAllRegistrations() throws Exception {

		ResponseEntity<Registration[]> response = restTemplate.getForEntity(createPort("/registrations/"),
				Registration[].class);
		Registration[] mockRegistration = response.getBody();

		assertTrue(mockRegistration[0].getEmail().equals("will@gmail.com"));
		assertTrue(mockRegistration[1].getEmail().equals("johnny@gmail.com"));
	}

	/**
	 * createRegistrations creates a new Registration and asserts the values
	 * @throws Exception
	 */
	@Test
	public void createRegistrations() throws Exception {

		Registration mockRegistration = new Registration("Mahi", "mahi", "Berlin", "mahi@gmail.com",
				new BigDecimal("15788887777"));
		ResponseEntity<Registration> response = restTemplate.postForEntity(createPort("/registrations/"),
				mockRegistration, Registration.class);

		assertTrue(response.getBody().getName().equals("Mahi"));
	}

	/**
	 * updateRegistration updates the given Registration instance and asserts the values
	 * @throws Exception
	 */
	@Test
	public void updateRegistration() throws Exception {

		ResponseEntity<Registration> response = restTemplate.getForEntity(createPort("/registrations/5"),
				Registration.class);

		assertTrue(response.getBody().getName().equals("Denzel"));

		Registration mockRegistration = new Registration("Mahi", "mahi", "Cologne", "mahi@gmail.com",
				new BigDecimal("12311111111"));
		restTemplate.put(createPort("/registrations/5"), mockRegistration);

		ResponseEntity<Registration> responseNew = restTemplate.getForEntity(createPort("/registrations/5"),
				Registration.class);

		assertTrue(responseNew.getBody().getName().equals("Mahi"));
		assertTrue(responseNew.getBody().getPhoneNumber().equals(new BigDecimal("12311111111")));

	}

	/**
	 * deleteRegistration deletes the given Registration instance and asserts the values
	 * @throws Exception
	 */
	@Test
	public void deleteRegistration() throws Exception {

		ResponseEntity<Registration[]> response = restTemplate.getForEntity(createPort("/registrations/"),
				Registration[].class);
		Registration[] mockRegistration = response.getBody();
		int registrationsBeforeDeletion = mockRegistration.length;

		restTemplate.delete(createPort("/registrations/1"));

		ResponseEntity<Registration[]> responseAfterDeletion = restTemplate.getForEntity(createPort("/registrations/"),
				Registration[].class);
		Registration[] mockRegistrationAfterDeletion = responseAfterDeletion.getBody();
		int registrationsAfterDeletion = mockRegistrationAfterDeletion.length;

		assertTrue((registrationsBeforeDeletion - 1) == registrationsAfterDeletion);

	}
	/**
	 * This method creates the dynamic port
	 * @param uri
	 * @return dynamic port appended to http://localhost
	 */

	private String createPort(final String uri) {
		return "http://localhost:" + port + uri;
	}

}
