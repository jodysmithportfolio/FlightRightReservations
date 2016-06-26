package flightrightacademy.flightrightreservations;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class calendarActivity extends AppCompatActivity {


    @Override
        protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Intent intent = getIntent();
        Calendar c = Calendar.getInstance();
        DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        TimePicker tp = (TimePicker) findViewById(R.id.timePicker);
        String plane  = "TBD";
        String instructor = "TBD";
        int inst = 0;
        inst =  intent.getIntExtra("instructor", 0);
        int pla = 0;
        pla = intent.getIntExtra("plane", 0);
        switch (inst){
            case 1: instructor = "George Wallace";
                    break;
            case 2: instructor = "John Waters";
                    break;
            case 3: instructor = "Maisie Williams";
            default: instructor = "Instructor TBD";
                    break;
        }
        switch (pla) {
            case 1: plane = "2016 C172S SKYHAWK SP";
                    break;
            case 2: plane  = "2015 C172 SKYHAWK TD";
                    break;
            case 3: plane = "2017 C172 TURBO SKYHAWK JT-A";
                    break;
        }
        int hours = 0;
        int minutes = 0;
        assert tp!=null;

        assert dp != null;
        CalendarView CV = dp.getCalendarView();

        if(Build.VERSION.SDK_INT<23){
            hours = tp.getCurrentHour();
            minutes = tp.getCurrentMinute();
        }else{
            hours = tp.getHour();
            minutes = tp.getMinute();
        }
        long begin = CV.getDate();
        long end = CV.getDate() + TimeUnit.HOURS.toMillis(2);
        final Intent insert = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
                .putExtra(CalendarContract.Events.TITLE, "Flying Lesson")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Airplane: " + plane
                        + " Instructor: " + instructor);
        final Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(insert);
            }
        });
    }

}
