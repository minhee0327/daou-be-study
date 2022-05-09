package com.design.pattern._01_createion._02_factory._03_java;

import org.springframework.cglib.core.Local;

import java.util.Calendar;
import java.util.Locale;

public class CalendarExample {
    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getClass());
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")).getClass());
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")).getClass());
    }
}
