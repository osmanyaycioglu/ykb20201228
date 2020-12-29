package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.training.ykb.rest.ENational;
import com.training.ykb.rest.Person;

public class TCKNCheckImpl implements ConstraintValidator<TCKNCheck, Person> {

    private static final Logger logger = LoggerFactory.getLogger(TCKNCheckImpl.class);

    @Override
    public boolean isValid(final Person valueParam,
                           final ConstraintValidatorContext contextParam) {
        if (TCKNCheckImpl.logger.isInfoEnabled()) {
            TCKNCheckImpl.logger.info("Checking TCKN : " + valueParam);
        }

        //                TCKNCheckImpl.logger.info("Checking TCKN : %s",
        //                                          valueParam);

        ENational nationalLoc = valueParam.getNational();
        if (nationalLoc == ENational.TC) {
            // Check TCKN from other source
            // return true or false
            if (TCKNCheckImpl.logger.isInfoEnabled()) {
                TCKNCheckImpl.logger.info("Checked and OK : " + valueParam);
            }
            return true;
        }
        return true;
    }

}
