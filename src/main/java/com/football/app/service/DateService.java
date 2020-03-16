package com.football.app.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateService {

    public Date transformDate(String date) throws ParseException {

        Date startDataUP = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        return startDataUP;
    }
}
