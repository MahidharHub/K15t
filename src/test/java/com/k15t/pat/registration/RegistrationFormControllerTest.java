package com.k15t.pat.registration;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.k15t.pat.domain.Registration;
import com.k15t.pat.service.RegistrationService;
import com.k15t.pat.validations.ValidationMatcher;



/**
 * RegistrationFormControllerTest tests the RegistrationFormController.
 * 
 * @author Mahidhar
 * 
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = RegistrationFormController.class)
public class RegistrationFormControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RegistrationService registrationService;
	
	@MockBean
	private ValidationMatcher validationMatcher;
	
	
	/**
	 * retrieveRegistration retrieves the specific registration and asserts the value
	 * @throws Exception
	 */
	
	
	@Test
	public void retrieveRegistration() throws Exception {
		Registration mockRegistration = new Registration("Will","will","Cologne","will@gmail.com",new BigDecimal("15788887777"));
		
		Mockito.when(
				registrationService.read(Mockito.anyLong())).thenReturn(mockRegistration);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/registerforms/edit/1").accept(
				MediaType.ALL);

		MvcResult result = mockMvc.perform(requestBuilder)
								  .andExpect(status().isOk())
								  .andExpect(view().name("registration/registrationForm"))
				                   .andReturn();
		
		Map<String,Object> resultMap =  result.getModelAndView().getModel();
		Registration registration = (Registration) resultMap.get("registration");
		
		assertEquals("will@gmail.com", registration.getEmail());
		assertEquals("Will", registration.getName());
		
	}
	
	/**
	 * retrieveRegistrationAll  retrieves  all the registrations and asserts the values
	 * @throws Exception
	 */
	
	@Test
	public void retrieveRegistrationAll() throws Exception {
		Registration mockRegistration = new Registration("Will","will","Cologne","will@gmail.com",new BigDecimal("15788887777"));
		Registration mockRegistration2 = new Registration("Nicolas","nicolas","Berlin","nicolas@gmail.com",new BigDecimal("11188887777"));
		List<Registration> registrationList = new ArrayList<Registration>();
		registrationList.add(mockRegistration);
		registrationList.add(mockRegistration2);
		Mockito.when(
				registrationService.list()).thenReturn(registrationList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/registerforms/list").accept(
				MediaType.ALL);

		MvcResult result = mockMvc.perform(requestBuilder)
								  .andExpect(status().isOk())
								  .andExpect(view().name("registration/list"))
				                   .andReturn();
		
		Map<String,Object> resultMap =  result.getModelAndView().getModel();
		List<Registration> registrationNewList = (List<Registration>) resultMap.get("registrations");
		
		
		assertEquals("will@gmail.com", registrationNewList.get(0).getEmail());
		assertEquals("Will", registrationNewList.get(0).getName());
		
	}
	
	/**
	 * saveRegistration creates a new Registration and asserts the values
	 * @throws Exception
	 */
	@Test
	public void saveRegistration() throws Exception {
		Registration mockRegistration = new Registration("Will","will","Cologne","will@gmail.com",new BigDecimal("15788887777"));
		mockRegistration.setConfirmPassword("will");
		Mockito.when(
				validationMatcher.matchPasswords(Mockito.anyObject())).thenReturn(true);
		Mockito.when(
				registrationService.create(Mockito.anyObject())).thenReturn(mockRegistration);
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/registerforms/save")
				                                               .accept(MediaType.ALL);

		   mockMvc.perform(requestBuilder)
				  .andExpect(status().isOk())
				  .andReturn();	
	}
	
	/**
	 * deleteRegistration deletes the given Registration instance and asserts the values
	 * @throws Exception
	 */
	@Test
	public void deleteRegistration() throws Exception {
		Registration mockRegistration = new Registration("Will","will","Cologne","will@gmail.com",new BigDecimal("15788887777"));
		mockRegistration.setConfirmPassword("will");
		
		Mockito.when(
				registrationService.delete(Mockito.anyLong())).thenReturn(mockRegistration);
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/registerforms/delete/1")
				.accept(MediaType.ALL);

				mockMvc.perform(requestBuilder)
					   .andExpect(view().name("redirect:/registerforms/list"))
					   .andExpect(status().is3xxRedirection())
				       .andReturn();
	}
	
	
	
}
