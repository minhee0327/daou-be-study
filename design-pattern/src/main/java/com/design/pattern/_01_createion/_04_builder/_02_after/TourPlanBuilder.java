package com.design.pattern._01_createion._04_builder._02_after;

import com.design.pattern._01_createion._04_builder._01_before.TourPlan;

import java.time.LocalDate;

public interface TourPlanBuilder {

    TourPlanBuilder newInstance();

    // method chaining 을 위한 정의
    TourPlanBuilder title(String title);

    TourPlanBuilder nightsAndDays(int nights, int days);

    TourPlanBuilder startDate(LocalDate localDate);

    TourPlanBuilder whereToStay(String whereToStay);

    TourPlanBuilder addPlan(int day, String plan);

    //인스턴스의 상태를 체크할 수 있다.
    TourPlan getPlan();
}
