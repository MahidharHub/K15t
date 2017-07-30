package com.k15t.pat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.k15t.pat.domain.Registration;



/**
 * This interface extends Spring proprietary CrudRepository interface.
 * The basic CRUD method are already supplied supplied by the CrudRepository
 * @author Mahidhar
 *
 */
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

	
}
