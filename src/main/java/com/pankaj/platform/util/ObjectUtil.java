package com.pankaj.platform.util;


import com.pankaj.platform.exception.BloggingBusinessException;
import org.springframework.http.HttpStatus;

import java.util.Collection;

/**
 * A mixed-bag of useful utility methods, that are used within the application.
 *
 * Created by pardasap on 15/04/2016.
 */
public final class ObjectUtil {

    private ObjectUtil() {
    }

    /**
     * Checks that the given argument is not null. If it is, throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new BloggingBusinessException(HttpStatus.INTERNAL_SERVER_ERROR, text);
        }
        return arg;
    }

    /**
     * Checks that the given argument is not null. If it is, returns throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static <T> boolean checkIfNotNull(T arg) {
        if (arg != null) {
            return true;
        }

        return false;
    }


    /**
     * Checks that the given argument is strictly positive. If it is, throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static int checkPositive(int i, String name) {
        if (i <= 0) {
            throw new BloggingBusinessException(HttpStatus.INTERNAL_SERVER_ERROR, name + ": " + i + " (expected: > 0)");
        }

        return i;
    }

    /**
     * Checks that the given argument is strictly positive. If it is, throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static boolean checkIfPositive(int i) {
        if (i <= 0) {
            return false;
        }

        return true;
    }

    /**
     * Checks that the given argument is strictly positive. If it is, throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static long checkPositive(long i, String name) {
        if (i <= 0) {
            throw new BloggingBusinessException(HttpStatus.INTERNAL_SERVER_ERROR, name + ": " + i + " (expected: > 0)");
        }
        return i;
    }

    /**
     * Checks that the given argument is positive or zero. If it is, throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static int checkPositiveOrZero(int i, String name) {
        if (i < 0) {
            throw new BloggingBusinessException(HttpStatus.INTERNAL_SERVER_ERROR, name + ": " + i + " (expected: >= 0)");
        }
        return i;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is, throws {@link BloggingBusinessException}.
     * Otherwise, returns the argument.
     */
    public static <T> T[] checkNonEmpty(T[] array, String name) {
        checkNotNull(array, name);
        checkPositive(array.length, name + ".length");
        return array;
    }

    /**
     * Checks that the given argument is neither null nor empty.
     * If it is -- returns true else false
     */
    public static <T> boolean checkIfNonEmpty(T[] array) {
        return checkIfNotNull(array) && checkIfPositive(array.length) ? true : false;
    }

    /**
     * Checks and flags with either true or false -- depending
     * on whether if the collection is empty or not.
     */
    public static <T> boolean checkIfNotEmpty(Collection<T> collection) {
        if(null == collection || collection.size() == 0) return false;
        return true;
    }

    /**
     * checks if the collection is empty or not and hence throw the exception with the
     * input text else return the collection back.
     * @param collection
     * @param text
     * @param <T>
     * @return
     */
    public static <T> Collection<T> checkNotEmpty(Collection<T> collection, String text) {
        if(null == collection || collection.size() == 0) {
            throw new BloggingBusinessException(HttpStatus.INTERNAL_SERVER_ERROR, text);
        }

        return collection;
    }

    /**
     * Check if value is null then use defaultValue else return the value back.
     * @param value
     * @param defaultValue
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T> T checkNullSafeGet(T value, T defaultValue) {
        if(null == value) {
            return defaultValue;
        }

        return value;
    }

    /**
     * Resolves a possibly null Integer to a primitive int, using a default value.
     * @param wrapper the wrapper
     * @param defaultValue the default value
     * @return the primitive value
     */
    public static int intValue(Integer wrapper, int defaultValue) {
        return wrapper != null ? wrapper.intValue() : defaultValue;
    }



    /**
     * Resolves a possibly null Long to a primitive long, using a default value.
     * @param wrapper the wrapper
     * @param defaultValue the default value
     * @return the primitive value
     */
    public static long longValue(Long wrapper, long defaultValue) {
        return wrapper != null ? wrapper.longValue() : defaultValue;
    }
}
