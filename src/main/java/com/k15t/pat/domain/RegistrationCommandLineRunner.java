package com.k15t.pat.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.k15t.pat.repository.RegistrationRepository;

import java.math.BigDecimal;

/**
 * This component runs the CommandLineRunner and loads the initial values into
 * the database
 * 
 * @author Mahidhar
 *
 */

@Component
public class RegistrationCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RegistrationCommandLineRunner.class);

	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public void run(String... args) throws Exception {

		registrationRepository
				.save(new Registration("Will", "will", "Cologne", "will@gmail.com", new BigDecimal("15788887777")));
		registrationRepository.save(
				new Registration("Johnny", "Johnny", "Frankfurt", "johnny@gmail.com", new BigDecimal("15788887777")));
		registrationRepository.save(
				new Registration("Pacino", "pacino", "Berlin", "nicolas@gmail.com", new BigDecimal("15788887777")));
		registrationRepository.save(
				new Registration("Russel", "russel", "Hamburg", "crowe@gmail.com", new BigDecimal("15788887777")));
		registrationRepository.save(
				new Registration("Denzel", "denzel", "Cologne", "denzel@gmail.com", new BigDecimal("15788887777")));
		registrationRepository
				.save(new Registration("Brad", "brad", "Cologne", "pitt@gmail.com", new BigDecimal("15788887777")));
		registrationRepository.save(new Registration("Leonardo", "leonardo", "Cologne", "leonardo@gmail.com",
				new BigDecimal("15788887777")));
		registrationRepository
				.save(new Registration("Keanu", "reeves", "Cologne", "keanu@gmail.com", new BigDecimal("15788887777")));
		registrationRepository.save(
				new Registration("jackman", "jackman", "Cologne", "jackman@gmail.com", new BigDecimal("15788887777")));

		log.info("Initially loaded Registrations are.....");

		for (Registration registration : registrationRepository.findAll()) {
			log.info(registration.toString());
		}

	}

}