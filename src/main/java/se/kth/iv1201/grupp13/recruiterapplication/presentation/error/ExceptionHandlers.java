/*
 * The MIT License
 *
 * Copyright 2018 Leif Lindbäck <leifl@kth.se>.
 *
 */
package se.kth.iv1201.grupp13.recruiterapplication.presentation.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.kth.iv1201.grupp13.recruiterapplication.domain.IllegalRecruiterTransactionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Contains all exception handling methods.
 */
@Controller
@ControllerAdvice
public class ExceptionHandlers implements ErrorController {
    public static final String ERROR_PAGE_URL = "error";
    public static final String ERROR_TYPE_KEY = "errorType";
    public static final String GENERIC_ERROR = "generic";
    public static final String USER_NOT_FOUND = "user-not-found";
    public static final String CREATE_FAILED = "create";
    public static final String SEARCH_FAILED = "search";
    public static final String SAVE_FAILED = "save";
    static final String ERROR_PATH = "failure";
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

    /**
     * Exception handler for broken business rules.
     *
     * @return An appropriate error page.
     */
    @ExceptionHandler(IllegalRecruiterTransactionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(IllegalRecruiterTransactionException exception, Model model) {
        logExceptionDebugLevel(exception);
        if (exception.getMessage().toUpperCase().contains("USER")) {
            model.addAttribute(ERROR_TYPE_KEY, USER_NOT_FOUND);
        } else if (exception.getMessage().toUpperCase().contains("CREATE")) {        
            model.addAttribute(ERROR_TYPE_KEY, CREATE_FAILED);
        } else if (exception.getMessage().toUpperCase().contains("SAVE")) {        
            model.addAttribute(ERROR_TYPE_KEY, SAVE_FAILED);
        } else if (exception.getMessage().toUpperCase().contains("SEARCH")) {
            model.addAttribute(ERROR_TYPE_KEY, SEARCH_FAILED);
        } else {
            model.addAttribute(ERROR_TYPE_KEY, GENERIC_ERROR);
        } return ERROR_PAGE_URL;
    }

    /**
     * The most generic exception handler, will be used if there is not a more specific handler for the exception that
     * shall be handled.
     *
     * @return The generic error page.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception, Model model) {
        logExceptionErrorLevel(exception);
        model.addAttribute(ERROR_TYPE_KEY, GENERIC_ERROR);
        return ERROR_PAGE_URL;
    }

    private void logExceptionErrorLevel(Exception exception) {
        LOGGER.error("Exception handler got {}: {}", exception.getClass().getName(), exception.getMessage(), exception);
    }

    private void logExceptionDebugLevel(Exception exception) {
        LOGGER.debug("Exception handler got {}: {}", exception.getClass().getName(), exception.getMessage(), exception);
    }

    @GetMapping("/" + ERROR_PATH)
    public String handleHttpError(HttpServletRequest request, HttpServletResponse response, Model model) {
        LOGGER
            .debug("Http error handler got Http status: {}", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        String statusCode = extractHttpStatusCode(request);
        model.addAttribute(ERROR_TYPE_KEY, statusCode);
        response.setStatus(Integer.parseInt(statusCode));
        return ERROR_PAGE_URL;
    }

    private String extractHttpStatusCode(HttpServletRequest request) {
        return request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
    }

    // This method is never called. Could that be a bug in spring? I can not
    // find any call to an appropriate method named getErrorPath anywhere in
    // spring's source code. The path is instead set in application.properties,
    // in the property server.error.path. For this to work, there
    // must also be the property setting server.error.whitelabel.enabled=false.
    @Override
    public String getErrorPath() {
        return "/" + ERROR_PATH;
    }
}