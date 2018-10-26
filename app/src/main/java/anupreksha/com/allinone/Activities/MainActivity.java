package anupreksha.com.allinone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import anupreksha.com.allinone.R;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button6);
        b2=findViewById(R.id.button);
        b3=findViewById(R.id.button4);
       Button b4=findViewById(R.id.button7);
        b5=findViewById(R.id.button5);
        Button b6=findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Main2Activity.class);
                startActivity(myIntent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        SpeechActivity.class);
                startActivity(myIntent);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(MainActivity.this,
                        CurrentActivity.class);
                startActivity(myIntent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(MainActivity.this,
                        TextActivity.class);
                startActivity(myIntent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(MainActivity.this,
                        ScreenRecorderActivity.class);
                startActivity(myIntent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(MainActivity.this,
                        CompassActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
