package com.allmuslim.test;

import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;

public class IslamicCalendar {
	public static void main(String[] args) {
        HijrahDate date = HijrahChronology.INSTANCE.dateNow();
        System.out.println(date);
        System.out.println(IsoChronology.INSTANCE.date(date));
    }
}
