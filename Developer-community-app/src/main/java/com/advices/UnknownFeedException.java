package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class UnknownFeedException extends Exception
{
		public UnknownFeedException(String message)
		{
	        super(message);
	    }

}