package com.advices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class UnknownDeveloperException extends Exception
{
	
	public UnknownDeveloperException(String message)
	{
        super(message);
    }

}
