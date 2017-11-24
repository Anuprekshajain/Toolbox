package anupreksha.com.allinone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.button6);
        Button b2=findViewById(R.id.button);
        Button b3=findViewById(R.id.button4);
        Button b4=findViewById(R.id.button2);
        Button b5=findViewById(R.id.button5);
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
                        CropActivity.class);
                startActivity(myIntent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(MainActivity.this,
                        WeatherActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
