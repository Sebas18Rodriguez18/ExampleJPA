/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Aprendiz
 */
public class ConvertUtils {
    /**
     * Convertir una fecha a string
     * @param date
     * @return 
     */
    public static String dateToString(Date date)
    {
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String result = dateFormat.format(date);
        return result;
    }
    
    /** Convertir String en una fecha
     * @param 
     * @param text
     * @return
     * @throws ParseException 
     */
    public static Date stringToDate(String text) throws ParseException, java.text.ParseException
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }
    
    /**
     * Convertir una hora en String
     * @param date
     * @return 
     */
    public static String timeToString(Date date)
    {
        DateFormat dateFormat= new SimpleDateFormat("HH:mm");
        String result = dateFormat.format(date);
        return result;
    }
    
    /**
     * Convertir un String en una hora 
     * @param text
     * @return
     * @throws ParseException 
     */
    public static Date stringToTime(String text) throws ParseException, java.text.ParseException
    {
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    
    public static Date localDateToDate(LocalDate localDate)
    {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public static Date LocalTimeToDate(LocalTime localTime)
    {
        return Date.from(LocalDate.now()
                                                            .atTime(localTime)
                                                            .atZone(ZoneId.systemDefault())
                                                            .toInstant());
    }
    
    public static LocalDate dateToLocalDate(Date date) {
    return date.toInstant() 
               .atZone(ZoneId.systemDefault()) 
               .toLocalDate(); 
}
}
