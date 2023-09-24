package com.elyashevich.reddit.controller;


import com.elyashevich.reddit.exception.CommentException;
import com.elyashevich.reddit.exception.CommunityException;
import com.elyashevich.reddit.exception.PersonException;
import com.elyashevich.reddit.exception.PostException;
import com.elyashevich.reddit.exception.TopicException;
import com.elyashevich.reddit.utils.ErrorResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
            {
                    CommentException.class,
                    CommunityException.class,
                    PersonException.class,
                    PostException.class,
                    TopicException.class
            }
    )
    @ResponseBody
    public ErrorResponse handleException(RuntimeException exception) {
        return handleCustomException(exception.getMessage());
    }

    @NotNull
    public static ErrorResponse handleCustomException(String exception) {
        log.error(exception);
        return new ErrorResponse(exception);
    }
}
