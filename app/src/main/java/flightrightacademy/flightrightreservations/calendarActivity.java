package flightrightacademy.flightrightreservations;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class calendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Calendar c = Calendar.getInstance();
    
        final Intent insert = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, c.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, c.getTimeInMillis());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(insert);
            }
        });
    }
}
