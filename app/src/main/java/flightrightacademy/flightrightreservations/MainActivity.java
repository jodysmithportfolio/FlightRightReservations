package flightrightacademy.flightrightreservations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent nextActivity = new Intent(this, instructor.class);
        final ImageView v = (ImageView) findViewById(R.id.imageView2);
        if(v!=null){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextActivity.putExtra("plane", 1);
                    startActivity(nextActivity);
                }
            });
        }

        final ImageView v2 = (ImageView) findViewById(R.id.imageView3);
        if(v2!=null){
            v2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v2) {
                    nextActivity.putExtra("plane", 2);
                    startActivity(nextActivity);
                }
            });
        }

        final ImageView v3 = (ImageView) findViewById(R.id.imageView4);
        if(v3!=null){
            v3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v3) {
                    nextActivity.putExtra("plane", 3);
                    startActivity(nextActivity);
                }
            });
        }


    }

}
