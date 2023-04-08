package com.example.javacoursework.service.Impl;

import com.example.javacoursework.service.StringService;

public class StringServiceImpl implements StringService {

    public String getYearByEntryYearAndSemester(int semester, int entryYear){
        String year = new String();
        if(semester%2==1)
            year = "20"+(entryYear+semester-1)+"/"+(entryYear+semester);
        else if (semester%2==0)
            year = "20"+(entryYear+semester-2)+"/"+(entryYear+semester-1);
        return year;
    }

}
