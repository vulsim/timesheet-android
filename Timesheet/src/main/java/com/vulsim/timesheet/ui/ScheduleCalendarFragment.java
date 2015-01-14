package com.vulsim.timesheet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.parse.ParseObject;
import com.squareup.timessquare.CalendarPickerView;
import com.vulsim.timesheet.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vulsi_000 on 11.01.2015.
 */
public class ScheduleCalendarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
        final CalendarPickerView calendar = (CalendarPickerView ) rootView.findViewById(R.id.calendar_view);

        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);

        Calendar today = Calendar.getInstance();
        ArrayList<Date> dates = new ArrayList<Date>();
        for (int i = 0; i < 5; i++) {
            today.add(Calendar.DAY_OF_MONTH, 3);
            dates.add(today.getTime());
        }

        calendar.init(lastYear.getTime(), nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.SINGLE).withSelectedDate(new Date()).withHighlightedDates(dates);
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("foo", "bar");
                testObject.saveInBackground();
                Toast.makeText(getActivity(), "Sample toast 1", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

        return rootView;
    }
}
