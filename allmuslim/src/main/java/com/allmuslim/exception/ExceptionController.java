package com.allmuslim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(CustomException ex, WebRequest request) {
		String message=String.valueOf(ex.getLocalizedMessage());
        CustomResponse error = new CustomResponse(message);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(UserExist.class)
	public final ResponseEntity<?> UserExistException(UserExist ex, WebRequest request)
	{
		String message=String.valueOf(ex.getLocalizedMessage());
		return ResponseEntity.ok(message);
		
	}
}
