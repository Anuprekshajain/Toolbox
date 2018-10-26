package anupreksha.com.allinone.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import anupreksha.com.allinone.R;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    ImageView compass_img;
    TextView txt_compass;
    int mcompass;
    private SensorManager mSensorManager;
    private Sensor mRotationV, mAccelerometer, mMagnetometer;
    boolean haveSensor = false, haveSensor2 = false;
    float[] rMat = new float[9];
    float[] orientation = new float[3];
    private float[] mLastAccelerometer = new float[3];
    private float[] mLastMagnetometer = new float[3];
    private boolean mLastAccelerometerSet = false;
    private boolean mLastMagnetometerSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        compass_img = (ImageView) findViewById(R.id.img_compass);
        txt_compass = (TextView) findViewById(R.id.txt);

    }
    public void start() {
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null) {
            if ((mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) || (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null)) {
                noSensorsAlert();
            }
            else {
                mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                haveSensor = mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
                haveSensor2 = mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_UI);
            }
        }
        else{
            mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            haveSensor = mSensorManager.registerListener(this, mRotationV, SensorManager.SENSOR_DELAY_UI);
        }
    }
    public void noSensorsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Your device doesn't support the Compass.")
                .setCancelable(false)
                .setNegativeButton("Close",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        alertDialog.show();
    }
    public void stop() {
        if(haveSensor && haveSensor2){
            mSensorManager.unregisterListener(this,mAccelerometer);
            mSensorManager.unregisterListener(this,mMagnetometer);
        }
        else{
            if(haveSensor)
                mSensorManager.unregisterListener(this,mRotationV);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        start();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            SensorManager.getRotationMatrixFromVector(rMat, event.values);
            mcompass = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, mLastAccelerometer, 0, event.values.length);
            mLastAccelerometerSet = true;
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, mLastMagnetometer, 0, event.values.length);
            mLastMagnetometerSet = true;
        }
        if (mLastAccelerometerSet && mLastMagnetometerSet) {
            SensorManager.getRotationMatrix(rMat, null, mLastAccelerometer, mLastMagnetometer);
            SensorManager.getOrientation(rMat, orientation);
            mcompass = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;
        }

        mcompass = Math.round(mcompass);
        compass_img.setRotation(-mcompass);

        String where = "NW";

        if (mcompass >= 350 || mcompass <= 10)
            where = "N";
        if (mcompass < 350 && mcompass > 280)
            where = "NW";
        if (mcompass <= 280 && mcompass > 260)
            where = "W";
        if (mcompass <= 260 && mcompass > 190)
            where = "SW";
        if (mcompass <= 190 && mcompass > 170)
            where = "S";
        if (mcompass <= 170 && mcompass > 100)
            where = "SE";
        if (mcompass <= 100 && mcompass > 80)
            where = "E";
        if (mcompass <= 80 && mcompass > 10)
            where = "NE";


        txt_compass.setText(mcompass + "° " + where);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
