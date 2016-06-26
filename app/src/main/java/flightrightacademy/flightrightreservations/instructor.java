package flightrightacademy.flightrightreservations;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class instructor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Intent backToMain = new Intent(this, MainActivity.class);
        boolean altNavFlag = false; // determines if we got here by a back button, etc.
        int planeNum = intent.getIntExtra("plane", 0);
        if(planeNum == 0){
            altNavFlag = true;
            startActivity(backToMain);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        final Intent nextActivity = new Intent(this, Calendar.class);
        final ImageView v = (ImageView) findViewById(R.id.imageView2);
        if(v!=null){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextActivity.putExtra("instructor", 1);
                    startActivity(nextActivity);
                }
            });
        }

        final ImageView v2 = (ImageView) findViewById(R.id.imageView3);
        if(v2!=null){
            v2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v2) {
                    nextActivity.putExtra("instructor", 2);
                    startActivity(nextActivity);
                }
            });
        }

        final ImageView v3 = (ImageView) findViewById(R.id.imageView4);
        if(v3!=null){
            v3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v3) {
                    nextActivity.putExtra("instructor", 3);
                    startActivity(nextActivity);
                }
            });
        }




    }
}
