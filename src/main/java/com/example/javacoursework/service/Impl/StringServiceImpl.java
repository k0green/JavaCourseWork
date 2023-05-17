package com.example.javacoursework.service.Impl;

import com.example.javacoursework.service.StringService;

/**
 * Класс реализует интерфейс StringService и предоставляет
 * реализацию метода getYearByEntryYearAndSemester()
 *
 * @author Egor
 * @version 1.0
 */
public class StringServiceImpl implements StringService {

    /**
     * метод для получения года обучения из семестра и года поступления
     * @param semester
     * @param entryYear
     * @return
     */
    public String getYearByEntryYearAndSemester(int semester, int entryYear){
        String year = new String();
        if(semester%2==1)
            year = "20"+(entryYear+semester-1)+"/"+(entryYear+semester);
        else if (semester%2==0)
            year = "20"+(entryYear+semester-2)+"/"+(entryYear+semester-1);
        return year;
    }

}
