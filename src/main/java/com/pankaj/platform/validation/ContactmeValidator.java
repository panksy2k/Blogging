/*
package com.pankaj.platform.validation;

import com.pankaj.platform.exception.BloggingBusinessException;
import com.pankaj.platform.util.ObjectUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

*/
/**
 * Created by pardasap on 17/08/2016.
 *//*

public class ContactmeValidator implements Validator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern INVALID_PHONE_NUMBER_PATTERN = Pattern.compile("[^\\d\\(\\) \\-\\+]");
    private static final Pattern INVALID_PROSPECT_NAME = Pattern.compile("[^\\p{L}\\.\\- \\'\\`]");
    private static final Pattern SECTION_HEADER_PATTERN = Pattern.compile("[^\\w\\s\\&\\,\\@\\.\\£\\$\\?\\-\\+]");
    private static final String MAX_ANY_CHARACTERS_ALLOWED = "^[\\s\\S]{0,65}";

    @Override
    public boolean supports(Class<?> aClass) {
        return (ContactmeValidator.class).isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prospectName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prospectEmailAddress", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prospectPhone", "required");


        ContactmeValidator lifePlannerDetails = (LifePlannerDetails) target;

        apply(lifePlannerDetails, errors, "prospectName");
        apply(lifePlannerDetails, errors, "prospectEmailAddress");
        apply(lifePlannerDetails, errors, "prospectPhone");
        apply(lifePlannerDetails, errors, "reportSection");
    }

    private void apply(ContactmeValidator target, Errors errors, String fieldName) {
        if("prospectName".equals(fieldName)) {
            if (!errors.hasFieldErrors(fieldName)) {
                String prospectName = target.getProspectName();

                if(INVALID_PROSPECT_NAME.matcher(prospectName).find()) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid characters in prospect name");
                }

                if(!prospectName.matches(MAX_ANY_CHARACTERS_ALLOWED)) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Crossed maximum allowed limit in Prospect name");
                }
            }
        }

        if("prospectEmailAddress".equals(fieldName)) {
            if (!errors.hasFieldErrors(fieldName)) {
                String prospectEmailAddress = target.getProspectEmailAddress();

                if (!prospectEmailAddress.matches(EMAIL_PATTERN)) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid prospect email pattern found!");
                }
            }
        }

        if("prospectPhone".equals(fieldName)) {
            if (!errors.hasFieldErrors(fieldName)) {
                String prospectPhone = target.getProspectPhone();

                if(INVALID_PHONE_NUMBER_PATTERN.matcher(prospectPhone).find()) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid prospect phone pattern found!");
                }

                if(prospectPhone.length() > 18) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Crossed maximum allowable limit for prospect phone number (18)!");
                }
            }
        }

        if("reportSection".equals(fieldName)) {
            LifePlannerDetails.Section[] sectionDetails = target.getReportSection();

            if(!ObjectUtil.checkIfNonEmpty(sectionDetails)) {
                throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Section details not found!");
            }

            for(LifePlannerDetails.Section section : sectionDetails) {
                ObjectUtil.checkNotNull(section.getName(), "Section name / title cannot be null!");
                if(SECTION_HEADER_PATTERN.matcher(section.getName()).find()) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid characters in Section header name");
                }

                if(!section.getName().matches(MAX_ANY_CHARACTERS_ALLOWED)){
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Crossed maximum allowed limit");
                }

                ObjectUtil.checkNotNull(section.getDescription(), "Section description cannot be null!");
                if(SECTION_HEADER_PATTERN.matcher(section.getName()).find()) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid characters in Section description");
                }

                if(!section.getDescription().matches(MAX_ANY_CHARACTERS_ALLOWED)){
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Crossed maximum allowed limit");
                }

                //Validate the sub-section details
                if(!ObjectUtil.checkIfNonEmpty(section.getSubSectionDetails())) {
                    throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Sub-Section Details are empty!");
                }

                for(LifePlannerDetails.Section.SubSectionItems subSection : section.getSubSectionDetails()) {
                    ObjectUtil.checkNotNull(subSection.getItemName(), "Sub-Section name cannot be null!");
                    if(SECTION_HEADER_PATTERN.matcher(subSection.getItemName()).find()) {
                        throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid characters in Sub-Section name");
                    }

                    if(!subSection.getItemName().matches(MAX_ANY_CHARACTERS_ALLOWED)){
                        throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Crossed maximum allowed limit in Sub-Section name");
                    }

                    ObjectUtil.checkNotNull(subSection.getItemValue(), "Sub-Section value cannot be null!");
                    if(SECTION_HEADER_PATTERN.matcher(subSection.getItemValue()).find()) {
                        throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Invalid characters in Sub-Section value");
                    }

                    if(!subSection.getItemValue().matches(MAX_ANY_CHARACTERS_ALLOWED)){
                        throw new BloggingBusinessException(HttpStatus.BAD_REQUEST, "Crossed maximum allowed limit in Sub-Section value");
                    }
                }
            }
        }
    }
}
*/
