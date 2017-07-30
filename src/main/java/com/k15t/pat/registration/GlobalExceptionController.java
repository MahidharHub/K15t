package com.k15t.pat.registration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.k15t.pat.exception.CustomGenericException;

/**
 * This is a GlobalExceptionController which is annotated with @ControllerAdice.
 * Methods in @ControllerAdvice apply globally to all Controllers
 * 
 * @author Mahidhar
 *
 */
@ControllerAdvice
public class GlobalExceptionController {

	/**
	 * 
	 * @param CustomGenericException
	 * @return ModelAndView
	 */
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("registration/error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	/**
	 * 
	 * @param Exception
	 * @return ModelAndView
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("registration/error");
		model.addObject("errMsg", "this is Exception class");

		return model;

	}

}