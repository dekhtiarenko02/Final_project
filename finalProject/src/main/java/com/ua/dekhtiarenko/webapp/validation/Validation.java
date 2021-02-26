package com.ua.dekhtiarenko.webapp.validation;

import java.util.regex.Pattern;

public class Validation {

    public boolean isValidText(String text){
        return Pattern.matches("[A-Za-zА-Яа-я]+", text);
    }

    public boolean isValidPassword(String password){
        return Pattern.matches("(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Za-z]).*$", password);
    }

    public boolean isValidEmail(String email){
        return Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", email);
    }

    public boolean isValidAuthorOrPublisher(String text){
        return Pattern.matches("([A-Za-z]+)(?:\\.|\\b)", text);
    }

    public boolean isValidNumbers(String id){
        return Pattern.matches("^(?:[-+0-9]\\d*|0)?(?:\\.\\d+)?$",id);
    }

    public boolean isValidUrlImg(String url){
        return Pattern.matches("(http(s?):/)(/[^/]+)+\" + \"\\.(?:jpg|gif|png)", url);
    }

    public boolean isValidPlot(String plot){
        return Pattern.matches("", plot);
    }

    public boolean isValidBool(String bool){
        return Pattern.matches("(true|false)", bool);
    }
}
