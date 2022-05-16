package com.design.pattern._01_createion._04_builder._02_after;

import com.design.pattern._01_createion._04_builder._01_before.TourPlan;

import java.time.LocalDate;

public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip(){
        return tourPlanBuilder
                .title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인 하고 짐 풀기")
                .addPlan(0, "저녁식사")
                .getPlan();
    }

    public TourPlan longBeachTrip(){
        return tourPlanBuilder
                .title("롱비치")
                .startDate(LocalDate.of(2021, 7, 15))
                .getPlan();
    }
}
