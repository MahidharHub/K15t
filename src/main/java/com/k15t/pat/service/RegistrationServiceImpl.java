package com.k15t.pat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k15t.pat.domain.Registration;
import com.k15t.pat.repository.RegistrationRepository;

/**
 * RegistrationServiceImpl implements the methods of RegistrationService to interact with the
 * RegistrationRepository
 * 
 * @author Mahidhar
 *
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationRepository registrationRepository;

	/**
	 * 
	 * @param registrationRepository
	 */
	@Autowired
	public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	
	@Override
	public Iterable<Registration> list() {

		return registrationRepository.findAll();
	}

	@Override
	public Registration create(Registration registration) {
		return registrationRepository.save(registration);
	}

	@Override
	public Registration read(long id) {
		return registrationRepository.findOne(id);
	}

	@Override
	public Registration update(long id, Registration registration) {
		Registration registrationUpdate = registrationRepository.findOne(id);
		if (registration.getName() != null) {
			registrationUpdate.setName(registration.getName());
		}
		if (registration.getEmail() != null) {
			registrationUpdate.setEmail(registration.getEmail());
		}
		if (registration.getAddress() != null) {
			registrationUpdate.setAddress(registration.getAddress());
		}
		if (registration.getPassword() != null) {
			registrationUpdate.setPassword(registration.getPassword());
		}
		if (registration.getPhoneNumber() != null) {
			registrationUpdate.setPhoneNumber(registration.getPhoneNumber());
		}
		return registrationRepository.save(registrationUpdate);
	}

	@Override
	public Registration delete(long id) {
		Registration registration = registrationRepository.findOne(id);
		registrationRepository.delete(id);
		return registration;
	}

}
