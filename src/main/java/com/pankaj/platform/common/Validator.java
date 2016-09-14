package com.pankaj.platform.common;

import com.pankaj.platform.util.ObjectUtil;

/**
 * Created by pardasap on 09/09/2016.
 */
public interface Validator<T> {

    /**
     * Verify that {@code anyObjectToValidate} is valid.
     * @param anyObjectToValidate -- the instance to validate;
     *
     * @throws com.pankaj.platform.exception.BloggingBusinessException
     */

    void validate(T anyObjectToValidate);

    @SuppressWarnings("rawtypes")
    Validator NOT_NULL = new Validator() {
        @Override
        public void validate(Object target) {
            ObjectUtil.checkNotNull(target, "value cannot be null");
        }
    };
}
