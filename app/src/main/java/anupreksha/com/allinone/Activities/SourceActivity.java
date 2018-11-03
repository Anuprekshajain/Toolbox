package anupreksha.com.allinone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import anupreksha.com.allinone.R;

public class SourceActivity extends AppCompatActivity {
 TextView t4, t5, t6 , t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17;
 String source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t7=findViewById(R.id.textView7);
        t8=findViewById(R.id.textView8);
        t9=findViewById(R.id.textView9);
        t10=findViewById(R.id.textView10);
        t11=findViewById(R.id.textView11);
        t12=findViewById(R.id.textView12);
        t13=findViewById(R.id.textView13);
        t14=findViewById(R.id.textView14);
        t15=findViewById(R.id.textView15);
        t16=findViewById(R.id.textView16);
        t17=findViewById(R.id.textView17);
    }

    public void onClick(View view){
        TextView clickedTextView = (TextView) view;
        source = clickedTextView.getText().toString();
        Intent intent=new Intent(this,CurrentActivity.class);
        intent.putExtra("Source",source);
        startActivity(intent);
    }
}
