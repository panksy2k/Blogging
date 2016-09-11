package com.pankaj.platform.validation;

import com.pankaj.platform.domain.ContactMe;
import com.pankaj.platform.exception.BloggingBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class ContactmeValidator implements Validator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern INVALID_PHONE_NUMBER_PATTERN = Pattern.compile("[^\\d\\(\\) \\-\\+]");
    private static final Pattern INVALID_PROSPECT_NAME = Pattern.compile("[^\\p{L}\\.\\- \\'\\`]");
    private static final Pattern SECTION_HEADER_PATTERN = Pattern.compile("[^\\w\\s\\&\\,\\@\\.\\£\\$\\?\\-\\+]");
    private static final String MAX_ANY_CHARACTERS_ALLOWED = "^[\\s\\S]{0,65}";

    @Override
    public boolean supports(Class<?> aClass) {
        return (ContactMe.class).isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personEmail", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephoneNumber", "required");

        ContactMe contactmeTarget = (ContactMe) target;

        apply(contactmeTarget, errors, "personEmail");
        apply(contactmeTarget, errors, "telephoneNumber");
        apply(contactmeTarget, errors, "fullName");
    }

    private void apply(ContactMe target, Errors errors, String fieldName) {
        if("personEmail".equals(fieldName)) {
            if (!errors.hasFieldErrors(fieldName)) {
                String personEmailAddress = target.getPersonEmail();

                if (!personEmailAddress.matches(EMAIL_PATTERN)) {
                    errors.rejectValue("personEmail", "invalid");
                }
            }
        }
        else if("telephoneNumber".equals(fieldName)) {
            if (!errors.hasFieldErrors(fieldName)) {
                String telephoneNumber = target.getTelephoneNumber();

                if(INVALID_PHONE_NUMBER_PATTERN.matcher(telephoneNumber).find()) {
                    errors.rejectValue("telephoneNumber", "invalid");
                }

                if(telephoneNumber.length() > 18) {
                    errors.rejectValue("telephoneNumber", "invalid");
                }
            }
        }
        else if("fullName".equals(fieldName)) {
            if (!errors.hasFieldErrors(fieldName)) {
                String personName = target.getFullName();

                if(INVALID_PROSPECT_NAME.matcher(personName).find()) {
                    errors.rejectValue("fullName", "invalid");
                }
            }
        }
    }
}
