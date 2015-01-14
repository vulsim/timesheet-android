package com.vulsim.timesheet;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by vulsi_000 on 14.01.2015.
 */
public class TimesheetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "3W0d99N1hy1QnUdgf12o378AA1TAt3bxiD5FG1gL", "uxFVDMsLygHoTt6bqzA2JtajHcZCtPpVO0GiCJnX");
    }
}
