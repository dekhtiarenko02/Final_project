package com.ua.dekhtiarenko.webapp.validation;

import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class Validation {

    private final Logger logger = Logger.getLogger(Validation.class);

    public boolean isValidText(String text) {
        logger.info("Start isValidText method");
        return Pattern.matches("[A-Za-zА-Яа-я]+", text);
    }

    public boolean isValidPassword(String password) {
        logger.info("Start isValidPassword method");
        return Pattern.matches("(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Za-z]).*$", password);
    }

    public boolean isValidEmail(String email) {
        logger.info("Start isValidEmail method");
        return Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", email);
    }

    public boolean isValidAuthorOrPublisher(String text) {
        logger.info("Start isValidAuthorOrPublisher method");
        return Pattern.matches("([A-Za-z]+)(?:\\.|\\b)", text);
    }

    public boolean isValidNumbers(String id) {
        logger.info("Start isValidNumbers method");
        return Pattern.matches("^(?:[-+0-9]\\d*|0)?(?:\\.\\d+)?$", id);
    }

    public boolean isValidUrlImg(String url) {
        logger.info("Start isValidUrlImg method");
        return Pattern.matches("(http(s?):/)(/[^/]+)+\\.(?:jpg|gif|png)", url);
    }

    public boolean isValidBool(String bool) {
        logger.info("Start isValidBool method");
        return Pattern.matches("(true|false)", bool);
    }
}
