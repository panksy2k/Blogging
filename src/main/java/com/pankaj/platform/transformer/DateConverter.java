package com.pankaj.platform.transformer;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by pankajpardasani on 28/09/2016.
 */
public class DateConverter implements Formatter<LocalDate> {
    private static final String ACCEPTABLE_DATE_PATTERN = "uuuu-MM-dd";

    public DateConverter() {
        super();
    }

    @Override
    public LocalDate parse(final String text, final Locale locale) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ACCEPTABLE_DATE_PATTERN, locale);
        LocalDate dateTime = LocalDate.parse(text, formatter);
        return dateTime;
    }

    @Override
    public String print(final LocalDate object, final Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ACCEPTABLE_DATE_PATTERN);
        String formattedDateTime = object.format(formatter);
        return formattedDateTime;
    }
}

