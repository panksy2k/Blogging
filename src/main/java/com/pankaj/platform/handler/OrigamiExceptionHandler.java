package com.pankaj.platform.handler;

import com.pankaj.platform.exception.BloggingBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by pardasap on 12/02/2016.
 */

@ControllerAdvice
public class OrigamiExceptionHandler extends AbstractExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(OrigamiExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);

        List<MediaType> mediaTypes = ex.getSupportedMediaTypes();
        if (!CollectionUtils.isEmpty(mediaTypes)) {
            headers.setAccept(mediaTypes);
        }

        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);

        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        if (!supportedMethods.isEmpty()) {
            headers.setAllow(supportedMethods);
        }

        return handleExceptionInternal(ex, this.produceErrorInstance(ex, status, request), headers, status, request);
    }

    @ExceptionHandler(BloggingBusinessException.class)
    @ResponseBody
    public ResponseEntity<?> handleResourceNotFoundException(BloggingBusinessException ex, HttpServletRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);

        final HttpStatus errorStatus = ex.getStatusCode() == null? HttpStatus.INTERNAL_SERVER_ERROR : ex.getStatusCode();
        return new ResponseEntity<>(this.produceErrorInstance(ex, errorStatus, request), null, errorStatus);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<?> handleRuntimeExceptions(RuntimeException ex, HttpServletRequest request) {
        LOG.error("Error: "+ex.getMessage(), ex);
        return new ResponseEntity<>(this.produceErrorInstance(ex, HttpStatus.INTERNAL_SERVER_ERROR, request), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
