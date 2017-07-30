package com.k15t.pat.validations;

import org.springframework.stereotype.Component;

import com.k15t.pat.domain.Registration;

/**
 * This component matches the password and confirmPassword entered by the user 
 * @author Mahidhar
 *
 */
@Component
public class ValidationMatcher {
	
	/**
	 * This method matches the password and confirmPassword entered by the user
	 * @param registraion
	 * @return boolean
	 */
	public boolean matchPasswords(Registration registraion){
		
		if(registraion.getPassword().equals(registraion.getConfirmPassword())){
			return true;	
		}else{
			return false;
		}	
	}

}
