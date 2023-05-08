package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.Validate.notNull;

class Schedule {

    private final Days days;
    private final Period period;

    Schedule(Days days, Period period) {
        //add validation
        //since its enum, we only need to validate is null]
        notNull(days);
        notNull(period);

        this.days = days;
        this.period = period;
    }

    @Override
    public String toString(){
        //TF H0830, MTH H1600
        return days + " " + period;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Schedule schedule = (Schedule) o;

        return days == schedule.days && period == schedule.period;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

enum Days{
    MTH, TF, WS
}

enum Period{
    //use start time to call the period
    H0830, H1000, H1130, H1300, H1430, H1600
}
